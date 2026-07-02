package com.projetopraticoDS.projetopraticoDS.services;

import com.projetopraticoDS.projetopraticoDS.entities.Visitante;
import com.projetopraticoDS.projetopraticoDS.repositories.VisitanteRepository;
import org.springframework.stereotype.Service;

@Service
public class VisitanteService extends CrudService<Visitante> {

    public VisitanteService(VisitanteRepository visitanteRepository) {
        super(visitanteRepository);
    }
}

