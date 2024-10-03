package com.example.m3s06strategypattern.factory;

import com.example.m3s06strategypattern.model.Pessoa;
import com.example.m3s06strategypattern.model.Profissao;

public interface ProfissaoStrategy {
    Profissao getProfissaoEsperada();
    void validate(Pessoa pessoa);
}
