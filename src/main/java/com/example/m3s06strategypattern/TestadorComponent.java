package com.example.m3s06strategypattern;

import com.example.m3s06strategypattern.model.Pessoa;
import com.example.m3s06strategypattern.model.PessoaBuilder;
import com.example.m3s06strategypattern.model.Profissao;
import com.example.m3s06strategypattern.service.CadastroDePessoasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestadorComponent {

    @Autowired
    public TestadorComponent(CadastroDePessoasService pessoasService) {
        Pessoa felipe = new Pessoa("Felipe de Jesus", Profissao.MEDICINA, "88888");

        /**
        Pessoa felipe2 = PessoaBuilder
                .umaPessoa()
                .comCpf("88888")
                .comNome("Felipe de Jesus")
                .daEnfermagem()
                .build();

        felipe.setCpf("88888");
        felipe.setNome("Felipe de Jesus");
        felipe.setProfissao(Profissao.MEDICINA);
         */

        pessoasService.cadastra(felipe);
    }
}
