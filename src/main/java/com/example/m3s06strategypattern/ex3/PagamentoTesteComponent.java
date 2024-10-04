package com.example.m3s06strategypattern.ex3;

import com.example.m3s06strategypattern.ex3.model.FormaPagamento;
import com.example.m3s06strategypattern.ex3.model.InformacoesPagamento;
import com.example.m3s06strategypattern.ex3.model.PessoaPaciente;
import com.example.m3s06strategypattern.ex3.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoTesteComponent {

    @Autowired
    public PagamentoTesteComponent(PagamentoService service) {
        PessoaPaciente felipe = new PessoaPaciente();
        InformacoesPagamento informacoesPixFelipe = new InformacoesPagamento();
        service.processaPagamento(felipe, FormaPagamento.CONVENIO_UNIMED, informacoesPixFelipe, 50.0f);
    }


}
