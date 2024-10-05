package com.example.m3s06strategypattern.ex4;

import com.example.m3s06strategypattern.model.Remedio;

public interface SalvarRemedioUseCase {
    Remedio salvar(String nome, Integer dosagemEmMg);
}
