package com.projetopraticoDS.projetopraticoDS.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "tb_mandato")
public class Mandato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMandato;

    @Column(nullable = false)
    private LocalDate dataInicio;

    private LocalDate dataFim;

    @ManyToOne
    @JoinColumn(name = "idPessoaSindico")
    private Pessoa sindico;

    public Mandato() {
    }

    public Mandato(Long idMandato, LocalDate dataInicio, LocalDate dataFim, Pessoa sindico) {
        this.idMandato = idMandato;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.sindico = sindico;
    }

    public Long getIdMandato() {
        return idMandato;
    }

    public void setIdMandato(Long idMandato) {
        this.idMandato = idMandato;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Pessoa getSindico() {
        return sindico;
    }

    public void setSindico(Pessoa sindico) {
        this.sindico = sindico;
    }
}

