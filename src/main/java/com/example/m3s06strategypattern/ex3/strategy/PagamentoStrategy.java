package com.example.m3s06strategypattern.ex3.strategy;

import com.example.m3s06strategypattern.ex3.model.FormaPagamento;
import com.example.m3s06strategypattern.ex3.model.InformacoesPagamento;
import com.example.m3s06strategypattern.ex3.model.PessoaPaciente;

public interface PagamentoStrategy {
    FormaPagamento tipoDePagamento();
    void processaPagamento(PessoaPaciente paciente, InformacoesPagamento informacoesPagamento, Float valor);
}
