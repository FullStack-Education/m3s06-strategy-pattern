package com.example.m3s06strategypattern.ex3.strategy;

import com.example.m3s06strategypattern.ex3.model.FormaPagamento;
import com.example.m3s06strategypattern.ex3.model.InformacoesPagamento;
import com.example.m3s06strategypattern.ex3.model.PessoaPaciente;
import com.example.m3s06strategypattern.ex3.exception.RegraDeNegocioException;
import com.example.m3s06strategypattern.ex3.service.BradescoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConvenioBradescoPagamentoStrategy implements PagamentoStrategy {

    @Autowired
    private BradescoService bradescoService;

    @Override
    public FormaPagamento tipoDePagamento() {
        return FormaPagamento.CONVENIO_BRADESCO;
    }

    @Override
    public void processaPagamento(PessoaPaciente paciente, InformacoesPagamento informacoesPagamento, Float valor) {
        if(paciente.getCpf() == null) {
            throw new RegraDeNegocioException("Informaão obrigatórias nao preenchidas. Preencha o CPF.");
        }
        bradescoService.processaPagamento(paciente.getCpf(), informacoesPagamento.getCpfMedico(), valor);
    }
}
