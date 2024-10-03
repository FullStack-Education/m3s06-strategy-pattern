package com.example.m3s06strategypattern.repository;

import com.example.m3s06strategypattern.model.Pessoa;
import org.springframework.stereotype.Component;

@Component
public class PessoaRepository {
    public void save(Pessoa pessoa) {
        System.out.println("Pessoa salva com sucesso: "+pessoa.toString());
    }
}
