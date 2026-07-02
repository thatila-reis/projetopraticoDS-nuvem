package com.projetopraticoDS.projetopraticoDS.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_movimentacao")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovimentacao;

    @Column(nullable = false)
    @NotNull(message = "A data da movimentacao e obrigatoria")
    private LocalDate data;

    @Column(nullable = false)
    @NotBlank(message = "A hora da movimentacao e obrigatoria")
    private String hora;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O tipo da movimentacao e obrigatorio")
    private Tipo tipo;

    @Column(length = 30)
    private String categoria = "Morador";

    @ManyToOne
    @JoinColumn(name = "idApartamento")
    @NotNull(message = "O apartamento da movimentacao e obrigatorio")
    private Apartamento idApartamento;

    @ManyToOne
    @JoinColumn(name = "idPessoaMorador")
    @NotNull(message = "O morador da movimentacao e obrigatorio")
    private Pessoa morador;

    public Movimentacao() {
    }

    public Movimentacao(Long idMovimentacao, LocalDate data, String hora, Tipo tipo, Apartamento idApartamento,
            Pessoa morador) {
        this.idMovimentacao = idMovimentacao;
        this.data = data;
        this.hora = hora;
        this.tipo = tipo;
        this.idApartamento = idApartamento;
        this.morador = morador;
    }

    public Long getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(Long idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Apartamento getIdApartamento() {
        return idApartamento;
    }

    public void setIdApartamento(Apartamento idApartamento) {
        this.idApartamento = idApartamento;
    }

    public Pessoa getMorador() {
        return morador;
    }

    public void setMorador(Pessoa morador) {
        this.morador = morador;
    }


}
