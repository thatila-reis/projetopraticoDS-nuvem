package com.projetopraticoDS.projetopraticoDS.controllers;

import com.projetopraticoDS.projetopraticoDS.entities.Morador;
import com.projetopraticoDS.projetopraticoDS.services.MoradorService;
import jakarta.validation.Valid;
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
@RequestMapping("/api/moradores")
public class MoradorController {

    private final MoradorService moradorService;

    public MoradorController(MoradorService moradorService) {
        this.moradorService = moradorService;
    }

    @GetMapping
    public List<Morador> listar() {
        return moradorService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Morador> buscarPorId(@PathVariable Long id) {
        return moradorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Morador cadastrar(@Valid @RequestBody Morador morador) {
        return moradorService.salvar(morador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Morador> atualizar(@PathVariable Long id, @Valid @RequestBody Morador morador) {
        if (!moradorService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }

        morador.setIdMorador(id);
        return ResponseEntity.ok(moradorService.salvar(morador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!moradorService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }

        moradorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
