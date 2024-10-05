package com.example.m3s06strategypattern.ex4;

import com.example.m3s06strategypattern.model.Estoque;
import com.example.m3s06strategypattern.model.Remedio;
import com.example.m3s06strategypattern.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdicionarEstoqueUseCaseImpl implements AdicionarEstoqueUseCase {
    private final GaranteExistenciaRemedioUseCase existenciaRemedioUseCase;
    private final EstoqueRepository estoqueRepository;

    @Autowired
    public AdicionarEstoqueUseCaseImpl(EstoqueRepository estoqueRepository,
                                       GaranteExistenciaRemedioUseCase existenciaRemedioUseCase) {

        this.estoqueRepository = estoqueRepository;
        this.existenciaRemedioUseCase = existenciaRemedioUseCase;
    }

    @Override
    public void adicionar(Integer quantidade, Integer remedioId, String remedioNome, Integer remedioDosagemMg) {
        validaQuantidadePositiva(quantidade);
        Remedio remedio = existenciaRemedioUseCase.obtenhaRemedio(remedioId, remedioNome, remedioDosagemMg);
        Estoque estoque = encontraEstoque(remedio);
        estoque.setQuantidade(estoque.getQuantidade() + quantidade);

        estoqueRepository.save(estoque);
    }

    private Estoque encontraEstoque(Remedio remedio) {
        Estoque estoqueAtual = estoqueRepository.getEstoqueAtual(remedio.getId());
        if (estoqueAtual == null) {
            estoqueAtual = new Estoque();
            estoqueAtual.setQuantidade(0);
            estoqueAtual.setIdRemedio(remedio.getId());
        }
        return estoqueAtual;
    }

    private void validaQuantidadePositiva(Integer quantidade) {
        if (quantidade < 0) {
            throw new ParametroInvalidoException("quantidade", "Quantidade adicionada no estoque não pode ser negativa");
        }
    }
}
