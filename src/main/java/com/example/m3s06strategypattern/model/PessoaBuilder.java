package com.example.m3s06strategypattern.model;

public class PessoaBuilder {

    private Profissao profissao;
    private String nome;
    private String cpf;

    public static PessoaBuilder umaPessoa() {
        return new PessoaBuilder();
    }

    private PessoaBuilder() {
    }

    public PessoaBuilder daEnfermagem() {
        this.profissao = Profissao.ENFERMAGEM;
        return this;
    }

    public PessoaBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public PessoaBuilder comCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public Pessoa build() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setCpf(cpf);
        pessoa.setProfissao(profissao);

        return pessoa;
    }


}
