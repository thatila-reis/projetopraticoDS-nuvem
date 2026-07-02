package com.projetopraticoDS.projetopraticoDS.services;

import com.projetopraticoDS.projetopraticoDS.entities.Pessoa;
import com.projetopraticoDS.projetopraticoDS.repositories.PessoaRepository;
import org.springframework.stereotype.Service;

@Service
public class PessoaService extends CrudService<Pessoa> {

    public PessoaService(PessoaRepository pessoaRepository) {
        super(pessoaRepository);
    }
}

