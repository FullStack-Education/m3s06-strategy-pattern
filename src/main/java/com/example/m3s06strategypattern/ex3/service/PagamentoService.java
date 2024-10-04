package com.example.m3s06strategypattern.ex3.service;

import com.example.m3s06strategypattern.ex3.model.FormaPagamento;
import com.example.m3s06strategypattern.ex3.model.InformacoesPagamento;
import com.example.m3s06strategypattern.ex3.strategy.PagamentoStrategy;
import com.example.m3s06strategypattern.ex3.factory.PagamentoStrategyFactory;
import com.example.m3s06strategypattern.ex3.model.PessoaPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoStrategyFactory pagamentoStrategyFactory;

    public void processaPagamento(PessoaPaciente paciente,
                                  FormaPagamento formaPagamento,
                                  InformacoesPagamento informacoesPagamento,
                                  Float valor) {
        PagamentoStrategy pagamentoStrategy = pagamentoStrategyFactory.getStrategyParaPagamento(formaPagamento);
        pagamentoStrategy.processaPagamento(paciente, informacoesPagamento, valor);
    }
}