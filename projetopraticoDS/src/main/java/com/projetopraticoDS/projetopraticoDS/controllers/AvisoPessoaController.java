package com.projetopraticoDS.projetopraticoDS.controllers;

import com.projetopraticoDS.projetopraticoDS.entities.AvisoPessoa;
import com.projetopraticoDS.projetopraticoDS.services.AvisoPessoaService;
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
@RequestMapping("/api/avisos-pessoas")
public class AvisoPessoaController {

    private final AvisoPessoaService avisoPessoaService;

    public AvisoPessoaController(AvisoPessoaService avisoPessoaService) {
        this.avisoPessoaService = avisoPessoaService;
    }

    @GetMapping
    public List<AvisoPessoa> listar() {
        return avisoPessoaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvisoPessoa> buscarPorId(@PathVariable Long id) {
        return avisoPessoaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AvisoPessoa cadastrar(@RequestBody AvisoPessoa avisoPessoa) {
        return avisoPessoaService.salvar(avisoPessoa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvisoPessoa> atualizar(@PathVariable Long id, @RequestBody AvisoPessoa avisoPessoa) {
        if (!avisoPessoaService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }

        avisoPessoa.setIdAvisoPessoa(id);
        return ResponseEntity.ok(avisoPessoaService.salvar(avisoPessoa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!avisoPessoaService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }

        avisoPessoaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

