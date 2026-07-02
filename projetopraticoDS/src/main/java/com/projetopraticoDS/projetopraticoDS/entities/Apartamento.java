package com.projetopraticoDS.projetopraticoDS.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "tb_apartamento")
public class Apartamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idApartamento;

    @Column(nullable = false)
    @NotBlank(message = "A identificacao do apartamento e obrigatoria")
    private String identificacao;

    @ManyToOne
    @JoinColumn(name = "idPessoaProprietario")
    @NotNull(message = "O proprietario do apartamento e obrigatorio")
    private Pessoa idPessoaProprietario;

    @ManyToOne
    @JoinColumn(name = "idTorre")
    @NotNull(message = "A torre do apartamento e obrigatoria")
    private Torre idTorre;

    public Apartamento(){

    }

    public Apartamento(Long idApartamento, String identificacao, Pessoa idPessoaProprietario, Torre idTorre) {
        this.idApartamento = idApartamento;
        this.identificacao = identificacao;
        this.idPessoaProprietario = idPessoaProprietario;
        this.idTorre = idTorre;
    }
    

    public Long getIdApartamento() {
        return idApartamento;
    }

    public void setIdApartamento(Long idApartamento) {
        this.idApartamento = idApartamento;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public Pessoa getIdPessoaProprietario() {
        return idPessoaProprietario;
    }

    public void setIdPessoaProprietario(Pessoa idPessoaProprietario) {
        this.idPessoaProprietario = idPessoaProprietario;
    }

    public Torre getIdTorre() {
        return idTorre;
    }

    public void setIdTorre(Torre idTorre) {
        this.idTorre = idTorre;
    }
    
}
