package com.projetopraticoDS.projetopraticoDS.controllers;

import com.projetopraticoDS.projetopraticoDS.entities.Mandato;
import com.projetopraticoDS.projetopraticoDS.services.MandatoService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mandatos")
public class MandatoController {

    private final MandatoService mandatoService;

    public MandatoController(MandatoService mandatoService) {
        this.mandatoService = mandatoService;
    }

    @GetMapping
    public List<Mandato> listar() {
        return mandatoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mandato> buscarPorId(@PathVariable Long id) {
        return mandatoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mandato cadastrar(@RequestBody Mandato mandato) {
        return mandatoService.salvar(mandato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mandato> atualizar(@PathVariable Long id, @RequestBody Mandato mandato) {
        if (!mandatoService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }

        mandato.setIdMandato(id);
        return ResponseEntity.ok(mandatoService.salvar(mandato));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!mandatoService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }

        mandatoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

