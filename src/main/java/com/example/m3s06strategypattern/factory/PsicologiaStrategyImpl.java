package com.example.m3s06strategypattern.factory;

import com.example.m3s06strategypattern.external.CrpService;
import com.example.m3s06strategypattern.model.Pessoa;
import com.example.m3s06strategypattern.model.Profissao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PsicologiaStrategyImpl implements ProfissaoStrategy {
    @Autowired
    private CrpService crpService;


    @Override
    public Profissao getProfissaoEsperada() {
        return Profissao.PSICOLOGIA;
    }

    @Override
    public void validate(Pessoa pessoa) {
        crpService.valida(pessoa);
    }
}
