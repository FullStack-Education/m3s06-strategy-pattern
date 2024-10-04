package com.example.m3s06strategypattern.ex3.factory;

import com.example.m3s06strategypattern.ex3.model.FormaPagamento;
import com.example.m3s06strategypattern.ex3.strategy.PagamentoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PagamentoStrategyFactory {

    @Autowired
    private List<PagamentoStrategy> strategies;

    public PagamentoStrategy getStrategyParaPagamento(FormaPagamento formaPagamento) {
        for (PagamentoStrategy strategy : strategies) {
            if(strategy.tipoDePagamento().equals(formaPagamento)) {
                return strategy;
            }
        }

        return null;
    }
}
