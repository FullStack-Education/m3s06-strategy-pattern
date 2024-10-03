package com.example.m3s06strategypattern.factory;

import com.example.m3s06strategypattern.model.Pessoa;
import com.example.m3s06strategypattern.model.Profissao;
import com.example.m3s06strategypattern.service.CrnService;
import org.springframework.stereotype.Component;

@Component
public class NutricaoStrategyImpl implements ProfissaoStrategy {

    private CrnService crnService = new CrnService();

    @Override
    public Profissao getProfissaoEsperada() {
        return Profissao.NUTRICAO;
    }

    @Override
    public void validate(Pessoa pessoa) {
        crnService.valida(pessoa);
    }
}
