package com.projetopraticoDS.projetopraticoDS.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_torre")
public class Torre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTorre;

    @Column(nullable = false)
    @NotNull(message = "O numero da torre e obrigatorio")
    @Positive(message = "O numero da torre deve ser positivo")
    private Integer numero;

    @Column(nullable = false, length = 150)
    @NotBlank(message = "A descricao da torre e obrigatoria")
    @Size(max = 150, message = "A descricao deve ter no maximo 150 caracteres")
    private String descricao;

    public Torre() {
    }

    public Torre(Long idTorre, Integer numero, String descricao) {
        this.idTorre = idTorre;
        this.numero = numero;
        this.descricao = descricao;
    }

    public Long getIdTorre() {
        return idTorre;
    }

    public void setIdTorre(Long idTorre) {
        this.idTorre = idTorre;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
