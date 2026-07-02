package com.projetopraticoDS.projetopraticoDS.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoa;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "O nome e obrigatorio")
    @Size(max = 100, message = "O nome deve ter no maximo 100 caracteres")
    private String nome;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "O login e obrigatorio")
    @Size(max = 100, message = "O login deve ter no maximo 100 caracteres")
    private String login;
 
    @Column(nullable = false, length = 100)
    @NotBlank(message = "A senha e obrigatoria")
    @Size(max = 100, message = "A senha deve ter no maximo 100 caracteres")
    private String senha;
    
    @Column(nullable = false, length = 100)
    @NotBlank(message = "O CPF e obrigatorio")
    @Size(max = 100, message = "O CPF deve ter no maximo 100 caracteres")
    private String cpf;

    @Column(length = 30)
    private String tipo = "Morador";

    @Column(length = 30)
    private String telefone = "Nao informado";

    @Column(length = 30)
    private String status = "Ativo";


    public Pessoa() {
    }

    public Pessoa(Long idPessoa, String nome, String login, String senha, String cpf) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
    }

    public Pessoa(Long idPessoa, String nome, String login, String senha, String cpf, String tipo) {
        this(idPessoa, nome, login, senha, cpf);
        this.tipo = tipo;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
