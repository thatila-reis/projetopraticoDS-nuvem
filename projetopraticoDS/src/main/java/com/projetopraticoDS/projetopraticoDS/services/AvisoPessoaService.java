package com.projetopraticoDS.projetopraticoDS.services;

import com.projetopraticoDS.projetopraticoDS.entities.AvisoPessoa;
import com.projetopraticoDS.projetopraticoDS.repositories.AvisoPessoaRepository;
import org.springframework.stereotype.Service;

@Service
public class AvisoPessoaService extends CrudService<AvisoPessoa> {

    public AvisoPessoaService(AvisoPessoaRepository avisoPessoaRepository) {
        super(avisoPessoaRepository);
    }
}

