package com.example.m3s06strategypattern.service;

import com.example.m3s06strategypattern.factory.ProfissaoStrategy;
import com.example.m3s06strategypattern.factory.ProfissaoStrategyFactory;
import com.example.m3s06strategypattern.model.Pessoa;
import com.example.m3s06strategypattern.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroDePessoasService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ProfissaoStrategyFactory profissaoStrategyFactory;

    /**
     * Enfermeiro(a): COREN
     * Medico(a): CRM
     * Psicologo(a): CRP
     * Nutricao: CRN
     * Fisioterapeuta: CREFITO
     */

    /**
     *
     * @param pessoa
     */
    public void cadastra(Pessoa pessoa) {
        ProfissaoStrategy strategy = profissaoStrategyFactory.getStrategy(pessoa.getProfissao());
        strategy.validate(pessoa);

        pessoaRepository.save(pessoa);
    }
}
