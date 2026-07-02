package com.projetopraticoDS.projetopraticoDS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projetopraticoDS.projetopraticoDS.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}