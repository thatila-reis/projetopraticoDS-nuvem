package com.projetopraticoDS.projetopraticoDS.controllers;

import com.projetopraticoDS.projetopraticoDS.entities.Porteiro;
import com.projetopraticoDS.projetopraticoDS.services.PorteiroService;
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
@RequestMapping("/api/porteiros")
public class PorteiroController {

    private final PorteiroService porteiroService;

    public PorteiroController(PorteiroService porteiroService) {
        this.porteiroService = porteiroService;
    }

    @GetMapping
    public List<Porteiro> listar() {
        return porteiroService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Porteiro> buscarPorId(@PathVariable Long id) {
        return porteiroService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Porteiro cadastrar(@RequestBody Porteiro porteiro) {
        return porteiroService.salvar(porteiro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Porteiro> atualizar(@PathVariable Long id, @RequestBody Porteiro porteiro) {
        if (!porteiroService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }

        porteiro.setIdPorteiro(id);
        return ResponseEntity.ok(porteiroService.salvar(porteiro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!porteiroService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }

        porteiroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

