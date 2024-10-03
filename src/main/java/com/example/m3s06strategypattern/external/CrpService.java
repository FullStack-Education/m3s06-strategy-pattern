package com.example.m3s06strategypattern.external;

import com.example.m3s06strategypattern.model.Pessoa;
import org.springframework.stereotype.Component;

@Component
public class CrpService {
    public void valida(Pessoa pessoa) {
        throw new RuntimeException("Pessoa está com credencial vencida!"); //PsicologiaException
    }
}
