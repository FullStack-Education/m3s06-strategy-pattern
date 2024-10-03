package com.example.m3s06strategypattern.factory;

import com.example.m3s06strategypattern.model.Pessoa;
import com.example.m3s06strategypattern.model.Profissao;
import org.springframework.stereotype.Component;

@Component
public class FisioterapiaStrategyImpl implements ProfissaoStrategy {

    @Override
    public Profissao getProfissaoEsperada() {
        return Profissao.FISIOTERAPIA;
    }

    @Override
    public void validate(Pessoa pessoa) {
        System.out.println("Pessoa é fisioterapeuta válida!");
    }
}
