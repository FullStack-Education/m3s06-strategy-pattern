package com.example.m3s06strategypattern.ex2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicamentoTeste {

    @Autowired
    public MedicamentoTeste() {
        System.out.println(getDipirona().toString());
    }

    public Medicamento getDipirona() {
        return MedicamentoBuilder.umMedicamento()
                .comNome("Dipirona Sódica 500mg")
                .naDosagem(500).mg()
                .doLaboratorio("EMS")
                .comBula(new StringBuilder()
                        .append("Para que serve Dipirona Sódica?\n")
                        .append("Como a Dipirona Sódica tem ação analgésica e antipirética,")
                        .append(" ela serve para aliviar dores e também reduzir a febre no paciente. ")
                        .append("Além disso, é importante ressaltar que o remédio é bastante indicado ")
                        .append("para dor com intensidade leve e moderada.\n")
                        .append("Esse remédio também serve para tratar dores de dentes, além de cólicas ")
                        .append("menstruais e outras condições. ")
                        .append("Por ser acessível, ele pode ser encontrado nas mais diferentes redes de farmácias.\n")
                        .toString())
                .build();
    }
}
