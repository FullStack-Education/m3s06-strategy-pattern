package com.example.m3s06strategypattern.external;

import org.springframework.stereotype.Service;

@Service
public class CrmService {
    public void validaCrm(String numeroRegistroProfissao, String cpf) {
        System.out.println("Pessoa médica é válida");
    }
}
