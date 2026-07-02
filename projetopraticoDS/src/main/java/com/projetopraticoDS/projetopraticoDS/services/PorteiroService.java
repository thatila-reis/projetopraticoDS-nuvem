package com.projetopraticoDS.projetopraticoDS.services;

import com.projetopraticoDS.projetopraticoDS.entities.Porteiro;
import com.projetopraticoDS.projetopraticoDS.repositories.PorteiroRepository;
import org.springframework.stereotype.Service;

@Service
public class PorteiroService extends CrudService<Porteiro> {

    public PorteiroService(PorteiroRepository porteiroRepository) {
        super(porteiroRepository);
    }
}

