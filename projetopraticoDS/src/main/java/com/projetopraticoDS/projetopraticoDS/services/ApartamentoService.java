package com.projetopraticoDS.projetopraticoDS.services;

import com.projetopraticoDS.projetopraticoDS.entities.Apartamento;
import com.projetopraticoDS.projetopraticoDS.repositories.ApartamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class ApartamentoService extends CrudService<Apartamento> {

    public ApartamentoService(ApartamentoRepository apartamentoRepository) {
        super(apartamentoRepository);
    }
}

