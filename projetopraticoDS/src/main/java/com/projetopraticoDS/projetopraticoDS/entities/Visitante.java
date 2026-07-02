package com.projetopraticoDS.projetopraticoDS.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_visitante")
public class Visitante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVisitante;

    @Column(length = 100)
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoa;

    public Visitante() {
    }

    public Visitante(Long idVisitante, String observacao, Pessoa pessoa) {
        this.idVisitante = idVisitante;
        this.observacao = observacao;
        this.pessoa = pessoa;
    }

    public Long getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(Long idVisitante) {
        this.idVisitante = idVisitante;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}

