package com.projetopraticoDS.projetopraticoDS.services;

import com.projetopraticoDS.projetopraticoDS.entities.Morador;
import com.projetopraticoDS.projetopraticoDS.repositories.MoradorRepository;
import org.springframework.stereotype.Service;

@Service
public class MoradorService extends CrudService<Morador> {

    public MoradorService(MoradorRepository moradorRepository) {
        super(moradorRepository);
    }
}

