package com.projetopraticoDS.projetopraticoDS.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_morador")
public class Morador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMorador;

    @ManyToOne
    @JoinColumn(name = "idApartamento")
    @NotNull(message = "O apartamento do morador e obrigatorio")
    private Apartamento idApartamento;

    @ManyToOne
    @JoinColumn(name = "idPessoaProprietaria")
    @NotNull(message = "A pessoa proprietaria do morador e obrigatoria")
    private Pessoa idPessoaProprietaria;

    public Morador() {
    }

    public Morador(Long idMorador, Apartamento idApartamento, Pessoa idPessoaProprietaria) {
        this.idMorador = idMorador;
        this.idApartamento = idApartamento;
        this.idPessoaProprietaria = idPessoaProprietaria;
    }

    public Long getIdMorador() {
        return idMorador;
    }

    public void setIdMorador(Long idMorador) {
        this.idMorador = idMorador;
    }

    public Apartamento getIdApartamento() {
        return idApartamento;
    }

    public void setIdApartamento(Apartamento idApartamento) {
        this.idApartamento = idApartamento;
    }

    public Pessoa getIdPessoaProprietaria() {
        return idPessoaProprietaria;
    }

    public void setIdPessoaProprietaria(Pessoa idPessoaProprietaria) {
        this.idPessoaProprietaria = idPessoaProprietaria;
    }
}
