package com.example.m3s06strategypattern.model;

import java.time.LocalDate;


public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private Profissao profissao;
    private String cpf;
    private String numeroRegistroProfissao;

    public Pessoa() {
    }

    public Pessoa(String nome, Profissao profissao, String cpf) {
        this();
        this.nome = nome;
        this.profissao = profissao;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumeroRegistroProfissao() {
        return numeroRegistroProfissao;
    }

    public void setNumeroRegistroProfissao(String numeroRegistroProfissao) {
        this.numeroRegistroProfissao = numeroRegistroProfissao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", profissao=" + profissao +
                '}';
    }
}
