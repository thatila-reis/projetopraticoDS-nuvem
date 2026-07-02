package com.projetopraticoDS.projetopraticoDS.services;

import com.projetopraticoDS.projetopraticoDS.entities.Encomenda;
import com.projetopraticoDS.projetopraticoDS.repositories.EncomendaRepository;
import org.springframework.stereotype.Service;

@Service
public class EncomendaService extends CrudService<Encomenda> {

    public EncomendaService(EncomendaRepository encomendaRepository) {
        super(encomendaRepository);
    }
}

