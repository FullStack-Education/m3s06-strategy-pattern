package com.example.m3s06strategypattern.factory;

import com.example.m3s06strategypattern.model.Profissao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfissaoStrategyFactory {

    @Autowired
    private List<ProfissaoStrategy> strategies;

    public ProfissaoStrategy getStrategy(Profissao profissao) {

        for (ProfissaoStrategy strategy : strategies) {
            if(strategy.getProfissaoEsperada().equals(profissao)) {
                return strategy;
            }
        }


        throw new RuntimeException("Não foi possível encontrar uma estratégia para essa profissão");
    }
}
