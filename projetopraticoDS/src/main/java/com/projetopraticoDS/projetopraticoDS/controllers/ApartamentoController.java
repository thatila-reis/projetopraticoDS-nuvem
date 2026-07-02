package com.projetopraticoDS.projetopraticoDS.controllers;

import com.projetopraticoDS.projetopraticoDS.entities.Apartamento;
import com.projetopraticoDS.projetopraticoDS.services.ApartamentoService;
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
@RequestMapping("/api/apartamentos")
public class ApartamentoController {

    private final ApartamentoService apartamentoService;

    public ApartamentoController(ApartamentoService apartamentoService) {
        this.apartamentoService = apartamentoService;
    }

    @GetMapping
    public List<Apartamento> listar() {
        return apartamentoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apartamento> buscarPorId(@PathVariable Long id) {
        return apartamentoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Apartamento cadastrar(@Valid @RequestBody Apartamento apartamento) {
        return apartamentoService.salvar(apartamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Apartamento> atualizar(@PathVariable Long id, @Valid @RequestBody Apartamento apartamento) {
        if (!apartamentoService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }

        apartamento.setIdApartamento(id);
        return ResponseEntity.ok(apartamentoService.salvar(apartamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!apartamentoService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }

        apartamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
