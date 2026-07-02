package com.projetopraticoDS.projetopraticoDS.controllers;

import com.projetopraticoDS.projetopraticoDS.entities.Visitante;
import com.projetopraticoDS.projetopraticoDS.services.VisitanteService;
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
@RequestMapping("/api/visitantes")
public class VisitanteController {

    private final VisitanteService visitanteService;

    public VisitanteController(VisitanteService visitanteService) {
        this.visitanteService = visitanteService;
    }

    @GetMapping
    public List<Visitante> listar() {
        return visitanteService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visitante> buscarPorId(@PathVariable Long id) {
        return visitanteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Visitante cadastrar(@RequestBody Visitante visitante) {
        return visitanteService.salvar(visitante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Visitante> atualizar(@PathVariable Long id, @RequestBody Visitante visitante) {
        if (!visitanteService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }

        visitante.setIdVisitante(id);
        return ResponseEntity.ok(visitanteService.salvar(visitante));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!visitanteService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }

        visitanteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

