package com.projetopraticoDS.projetopraticoDS.services;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class CrudService<T> {

    private final JpaRepository<T, Long> repository;

    protected CrudService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    public List<T> listar() {
        return repository.findAll();
    }

    public Optional<T> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public T salvar(T entidade) {
        return repository.save(entidade);
    }

    public boolean existePorId(Long id) {
        return repository.existsById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

