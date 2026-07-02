package com.projetopraticoDS.projetopraticoDS.controllers;

import com.projetopraticoDS.projetopraticoDS.entities.Aviso;
import com.projetopraticoDS.projetopraticoDS.services.AvisoService;
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
@RequestMapping("/api/avisos")
public class AvisoController {

    private final AvisoService avisoService;

    public AvisoController(AvisoService avisoService) {
        this.avisoService = avisoService;
    }

    @GetMapping
    public List<Aviso> listar() {
        return avisoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aviso> buscarPorId(@PathVariable Long id) {
        return avisoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Aviso cadastrar(@RequestBody Aviso aviso) {
        return avisoService.salvar(aviso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aviso> atualizar(@PathVariable Long id, @RequestBody Aviso aviso) {
        if (!avisoService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }

        aviso.setIdAviso(id);
        return ResponseEntity.ok(avisoService.salvar(aviso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!avisoService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }

        avisoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

