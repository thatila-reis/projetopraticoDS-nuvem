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
@Table(name = "tb_aviso_pessoa")
public class AvisoPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvisoPessoa;

    @Column(nullable = false, length = 255)
    private String descricao;

    @Column(nullable = false)
    private LocalDate dataRegistro;

    private LocalDate dataLeitura;

    @ManyToOne
    @JoinColumn(name = "idAviso")
    private Aviso aviso;

    @ManyToOne
    @JoinColumn(name = "idPessoaMorador")
    private Pessoa pessoaMorador;

    public AvisoPessoa() {
    }

    public AvisoPessoa(Long idAvisoPessoa, String descricao, LocalDate dataRegistro, LocalDate dataLeitura,
            Aviso aviso, Pessoa pessoaMorador) {
        this.idAvisoPessoa = idAvisoPessoa;
        this.descricao = descricao;
        this.dataRegistro = dataRegistro;
        this.dataLeitura = dataLeitura;
        this.aviso = aviso;
        this.pessoaMorador = pessoaMorador;
    }

    public Long getIdAvisoPessoa() {
        return idAvisoPessoa;
    }

    public void setIdAvisoPessoa(Long idAvisoPessoa) {
        this.idAvisoPessoa = idAvisoPessoa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public LocalDate getDataLeitura() {
        return dataLeitura;
    }

    public void setDataLeitura(LocalDate dataLeitura) {
        this.dataLeitura = dataLeitura;
    }

    public Aviso getAviso() {
        return aviso;
    }

    public void setAviso(Aviso aviso) {
        this.aviso = aviso;
    }

    public Pessoa getPessoaMorador() {
        return pessoaMorador;
    }

    public void setPessoaMorador(Pessoa pessoaMorador) {
        this.pessoaMorador = pessoaMorador;
    }
}

