package com.projetopraticoDS.projetopraticoDS.services;

import com.projetopraticoDS.projetopraticoDS.entities.Aviso;
import com.projetopraticoDS.projetopraticoDS.repositories.AvisoRepository;
import org.springframework.stereotype.Service;

@Service
public class AvisoService extends CrudService<Aviso> {

    public AvisoService(AvisoRepository avisoRepository) {
        super(avisoRepository);
    }
}

