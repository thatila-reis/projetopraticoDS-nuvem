package com.projetopraticoDS.projetopraticoDS.controllers;

import com.projetopraticoDS.projetopraticoDS.entities.Torre;
import com.projetopraticoDS.projetopraticoDS.services.TorreService;
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
@RequestMapping("/api/torres")
public class TorreController {

    private final TorreService torreService;

    public TorreController(TorreService torreService) {
        this.torreService = torreService;
    }

    @GetMapping
    public List<Torre> listar() {
        return torreService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Torre> buscarPorId(@PathVariable Long id) {
        return torreService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Torre cadastrar(@Valid @RequestBody Torre torre) {
        return torreService.salvar(torre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Torre> atualizar(@PathVariable Long id, @Valid @RequestBody Torre torre) {
        if (!torreService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }

        torre.setIdTorre(id);
        return ResponseEntity.ok(torreService.salvar(torre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!torreService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }

        torreService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
