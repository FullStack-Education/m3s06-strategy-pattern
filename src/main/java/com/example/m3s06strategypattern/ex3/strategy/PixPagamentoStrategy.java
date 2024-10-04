package com.example.m3s06strategypattern.ex3.strategy;

import com.example.m3s06strategypattern.ex3.model.FormaPagamento;
import com.example.m3s06strategypattern.ex3.model.InformacoesPagamento;
import com.example.m3s06strategypattern.ex3.model.PessoaPaciente;
import com.example.m3s06strategypattern.ex3.service.BacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PixPagamentoStrategy implements PagamentoStrategy {

    @Autowired
    private BacenService bacenService;

    @Override
    public FormaPagamento tipoDePagamento() {
        return FormaPagamento.PIX;
    }

    @Override
    public void processaPagamento(PessoaPaciente paciente, InformacoesPagamento informacoesPagamento, Float valor) {
        if (informacoesPagamento.getIdTransacaoPix() != null) {
            bacenService.processaPix(informacoesPagamento.getIdTransacaoPix(), valor);
        } else {
            bacenService.geraChavePixParaPagamento(paciente.getChavePix(), valor);
        }

    }
}
