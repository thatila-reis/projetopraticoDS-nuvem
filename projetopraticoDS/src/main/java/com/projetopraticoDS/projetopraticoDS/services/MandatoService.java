package com.projetopraticoDS.projetopraticoDS.services;

import com.projetopraticoDS.projetopraticoDS.entities.Mandato;
import com.projetopraticoDS.projetopraticoDS.repositories.MandatoRepository;
import org.springframework.stereotype.Service;

@Service
public class MandatoService extends CrudService<Mandato> {

    public MandatoService(MandatoRepository mandatoRepository) {
        super(mandatoRepository);
    }
}

