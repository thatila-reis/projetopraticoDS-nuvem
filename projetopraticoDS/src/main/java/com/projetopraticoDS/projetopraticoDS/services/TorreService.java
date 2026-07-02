package com.projetopraticoDS.projetopraticoDS.services;

import com.projetopraticoDS.projetopraticoDS.entities.Torre;
import com.projetopraticoDS.projetopraticoDS.repositories.TorreRepository;
import org.springframework.stereotype.Service;

@Service
public class TorreService extends CrudService<Torre> {

    public TorreService(TorreRepository torreRepository) {
        super(torreRepository);
    }
}

