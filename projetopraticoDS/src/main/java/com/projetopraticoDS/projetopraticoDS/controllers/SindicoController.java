package com.projetopraticoDS.projetopraticoDS.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetopraticoDS.projetopraticoDS.entities.Sindico;
import com.projetopraticoDS.projetopraticoDS.services.SindicoService;

@RestController
@RequestMapping("/api/sindicos")
public class SindicoController {

    @Autowired
    private SindicoService service;

    @GetMapping
    public List<Sindico> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Sindico> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Sindico insert(@RequestBody Sindico sindico) {
        return service.insert(sindico);
    }

    @PutMapping("/{id}")
    public Sindico update(@PathVariable Long id, @RequestBody Sindico sindico) {
        return service.update(id, sindico);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
