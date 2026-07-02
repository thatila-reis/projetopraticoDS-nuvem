package com.projetopraticoDS.projetopraticoDS.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "tb_encomenda")
public class Encomenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEncomenda;

    @Column(nullable = false)
    @NotBlank(message = "A descricao da encomenda e obrigatoria")
    private String descricao;

    @Column(nullable = false) 
    @NotNull(message = "A data de recebimento e obrigatoria")
    private LocalDate dataRecebimento;

    @Column(nullable = false)
    @NotNull(message = "A data de entrega e obrigatoria")
    private LocalDate dataEntrega;

    @ManyToOne
    @JoinColumn(name = "idPessoaMorador")
    @NotNull(message = "O morador da encomenda e obrigatorio")
    private Pessoa morador;

    public Encomenda() {
    }

    public Long getIdEncomenda() {
        return idEncomenda;
    }

    public void setIdEncomenda(Long idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(LocalDate dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Pessoa getMorador() {
        return morador;
    }

    public void setMorador(Pessoa morador) {
        this.morador = morador;
    }
}
