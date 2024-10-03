package com.example.m3s06strategypattern.external;

public class EnfermagemException extends RuntimeException {
    public EnfermagemException(String mensagem, String numeroRegistroProfissao, String cpf) {
        super(new StringBuilder()
                .append(mensagem)
                .append("\nNumero COREN : " + numeroRegistroProfissao)
                .append("\nCPF : " + cpf).toString());
    }
}
