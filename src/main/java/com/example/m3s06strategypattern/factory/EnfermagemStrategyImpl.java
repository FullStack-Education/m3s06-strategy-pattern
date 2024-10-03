package com.example.m3s06strategypattern.factory;

import com.example.m3s06strategypattern.external.CorenService;
import com.example.m3s06strategypattern.model.Pessoa;
import com.example.m3s06strategypattern.model.Profissao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.m3s06strategypattern.model.Profissao.ENFERMAGEM;

@Component
public class EnfermagemStrategyImpl implements ProfissaoStrategy {

    @Autowired
    private CorenService corenService;

    @Autowired
    private CorenApiTokenManager corenApiTokenManager;

    @Override
    public Profissao getProfissaoEsperada() {
        return ENFERMAGEM;
    }

    @Override
    public void validate(Pessoa pessoa) {
        corenService.validaCoren(pessoa.getNumeroRegistroProfissao(), pessoa.getCpf(), corenApiTokenManager.getTemporaryToken());
    }
}
