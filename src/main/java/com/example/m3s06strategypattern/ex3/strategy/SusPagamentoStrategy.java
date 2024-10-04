package com.example.m3s06strategypattern.ex3.strategy;

import com.example.m3s06strategypattern.ex3.model.FormaPagamento;
import com.example.m3s06strategypattern.ex3.model.InformacoesPagamento;
import com.example.m3s06strategypattern.ex3.model.PessoaPaciente;
import com.example.m3s06strategypattern.ex3.exception.RegraDeNegocioException;
import com.example.m3s06strategypattern.ex3.service.SusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SusPagamentoStrategy implements PagamentoStrategy {
    @Autowired
    private SusService susService;

    @Override
    public FormaPagamento tipoDePagamento() {
        return FormaPagamento.SUS;
    }

    @Override
    public void processaPagamento(PessoaPaciente paciente, InformacoesPagamento informacoesPagamento, Float valor) {
        if(paciente.getCpf() == null || paciente.getNumeroPis() == null) {
            throw new RegraDeNegocioException("Informações obrigatórias nao preenchidas. Preencha Numero do PIS e CPF.");
        }

        susService.solicitaProcessoPagamento(paciente.getCpf(), paciente.getNumeroPis(), valor);
    }
}
