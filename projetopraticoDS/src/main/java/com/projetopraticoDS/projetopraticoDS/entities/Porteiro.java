package com.projetopraticoDS.projetopraticoDS.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_porteiro")
public class Porteiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPorteiro;

    @ManyToOne
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoa;

    public Porteiro() {
    }

    public Porteiro(Long idPorteiro, Pessoa pessoa) {
        this.idPorteiro = idPorteiro;
        this.pessoa = pessoa;
    }

    public Long getIdPorteiro() {
        return idPorteiro;
    }

    public void setIdPorteiro(Long idPorteiro) {
        this.idPorteiro = idPorteiro;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}

