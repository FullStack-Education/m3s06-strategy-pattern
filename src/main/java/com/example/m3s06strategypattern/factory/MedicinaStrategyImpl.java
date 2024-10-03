package com.example.m3s06strategypattern.factory;

import com.example.m3s06strategypattern.external.CrmService;
import com.example.m3s06strategypattern.model.Pessoa;
import com.example.m3s06strategypattern.model.Profissao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicinaStrategyImpl implements ProfissaoStrategy {
    @Autowired
    private CrmService crmService;


    @Override
    public Profissao getProfissaoEsperada() {
        return Profissao.MEDICINA;
    }

    @Override
    public void validate(Pessoa pessoa) {
        crmService.validaCrm(pessoa.getNumeroRegistroProfissao(), pessoa.getCpf());
    }
}
