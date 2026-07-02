package com.projetopraticoDS.projetopraticoDS.controllers;

import com.projetopraticoDS.projetopraticoDS.entities.Movimentacao;
import com.projetopraticoDS.projetopraticoDS.services.MovimentacaoService;
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
@RequestMapping("/api/movimentacoes")
public class MovimentacaoController {

    private final MovimentacaoService movimentacaoService;

    public MovimentacaoController(MovimentacaoService movimentacaoService) {
        this.movimentacaoService = movimentacaoService;
    }

    @GetMapping
    public List<Movimentacao> listar() {
        return movimentacaoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimentacao> buscarPorId(@PathVariable Long id) {
        return movimentacaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Movimentacao cadastrar(@Valid @RequestBody Movimentacao movimentacao) {
        return movimentacaoService.salvar(movimentacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movimentacao> atualizar(@PathVariable Long id, @Valid @RequestBody Movimentacao movimentacao) {
        if (!movimentacaoService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }

        movimentacao.setIdMovimentacao(id);
        return ResponseEntity.ok(movimentacaoService.salvar(movimentacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!movimentacaoService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }

        movimentacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
