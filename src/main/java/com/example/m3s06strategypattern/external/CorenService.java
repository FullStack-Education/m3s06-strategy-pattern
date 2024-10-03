package com.example.m3s06strategypattern.external;

import org.springframework.stereotype.Service;

@Service
public class CorenService {
    public void validaCoren(String numeroRegistroProfissao, String cpf, String temporaryToken) {
        System.out.println("Token emitido está válido + " + temporaryToken);

        if (cpf.startsWith("0")) {
            throw new EnfermagemException("Numero de registro não é valido para esse cpf ", numeroRegistroProfissao, cpf);
        }
        System.out.println("Pessoa enfermeira é válida!");
    }
}
