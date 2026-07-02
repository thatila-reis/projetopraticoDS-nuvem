package com.projetopraticoDS.projetopraticoDS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetopraticoDS.projetopraticoDS.entities.Sindico;
import com.projetopraticoDS.projetopraticoDS.repositories.SindicoRepository;

@Service
public class SindicoService {

    @Autowired
    private SindicoRepository repository;

    public List<Sindico> findAll() {
        return repository.findAll();
    }

    public Optional<Sindico> findById(Long id) {
        return repository.findById(id);
    }

    public Sindico insert(Sindico sindico) {
        return repository.save(sindico);
    }

    public Sindico update(Long id, Sindico sindicoAtualizado) {
        Sindico sindico = repository.findById(id).orElseThrow();

        sindico.setPessoa(sindicoAtualizado.getPessoa());

        return repository.save(sindico);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}