package com.example.m3s06strategypattern.ex4;

import com.example.m3s06strategypattern.model.Remedio;

public interface GaranteExistenciaRemedioUseCase {
    Remedio obtenhaRemedio(Integer remedioId, String remedioNome, Integer remedioDosagemMg);
}
