package com.example.m3s06strategypattern.ex2;

public class MedicamentoBuilder {

    private String nome;
    private int dosagem;
    private String unidade;
    private String laboratorio;
    private String bula;

    public static MedicamentoBuilder umMedicamento() {
        return new MedicamentoBuilder();
    }

    private MedicamentoBuilder() {
    }

    public MedicamentoBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public MedicamentoBuilder naDosagem(int dosagem) {
        this.dosagem = dosagem;
        return this;
    }

    public MedicamentoBuilder mg() {
        this.unidade = "Mg";
        return this;
    }

    public MedicamentoBuilder doLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
        return this;
    }

    public MedicamentoBuilder comBula(String bula) {
        this.bula = bula;
        return this;
    }

    public Medicamento build() {
        Medicamento medicamento = new Medicamento();
        medicamento.setNome(nome);
        medicamento.setDosagem(dosagem);
        medicamento.setUnidadeDosagem(unidade);
        medicamento.setNomeLaboratorio(laboratorio);
        medicamento.setBula(bula);
        return medicamento;
    }
}
