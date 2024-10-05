package com.example.m3s06strategypattern.ex4;

public interface AdicionarEstoqueUseCase {
    void adicionar(Integer quantidade, Integer remedioId, String remedioNome, Integer remedioDosagemMg);
}
