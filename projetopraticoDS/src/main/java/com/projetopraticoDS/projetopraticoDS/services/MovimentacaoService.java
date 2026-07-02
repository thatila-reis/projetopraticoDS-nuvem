package com.projetopraticoDS.projetopraticoDS.services;

import com.projetopraticoDS.projetopraticoDS.entities.Movimentacao;
import com.projetopraticoDS.projetopraticoDS.repositories.MovimentacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class MovimentacaoService extends CrudService<Movimentacao> {

    public MovimentacaoService(MovimentacaoRepository movimentacaoRepository) {
        super(movimentacaoRepository);
    }
}

