package com.projetopraticoDS.projetopraticoDS.controllers;

import com.projetopraticoDS.projetopraticoDS.entities.Encomenda;
import com.projetopraticoDS.projetopraticoDS.services.EncomendaService;
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
@RequestMapping("/api/encomendas")
public class EncomendaController {

    private final EncomendaService encomendaService;

    public EncomendaController(EncomendaService encomendaService) {
        this.encomendaService = encomendaService;
    }

    @GetMapping
    public List<Encomenda> listar() {
        return encomendaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Encomenda> buscarPorId(@PathVariable Long id) {
        return encomendaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Encomenda cadastrar(@Valid @RequestBody Encomenda encomenda) {
        return encomendaService.salvar(encomenda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Encomenda> atualizar(@PathVariable Long id, @Valid @RequestBody Encomenda encomenda) {
        if (!encomendaService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }

        encomenda.setIdEncomenda(id);
        return ResponseEntity.ok(encomendaService.salvar(encomenda));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!encomendaService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }

        encomendaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
