package com.example.m3s06strategypattern.ex4;

import static java.lang.String.format;

public class ParametroInvalidoException extends RuntimeException {
    private final String campo;

    public ParametroInvalidoException(String campo, String mensagem) {
        super(format("Campo %s é inválido: %s", campo, mensagem));
        this.campo = campo;
    }
}
