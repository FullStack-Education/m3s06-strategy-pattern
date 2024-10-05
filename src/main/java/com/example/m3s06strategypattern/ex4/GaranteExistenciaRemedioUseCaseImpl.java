package com.example.m3s06strategypattern.ex4;

import com.example.m3s06strategypattern.model.Remedio;
import com.example.m3s06strategypattern.repository.RemedioRepository;
import org.springframework.stereotype.Component;

@Component
public class GaranteExistenciaRemedioUseCaseImpl implements GaranteExistenciaRemedioUseCase {

    private final RemedioRepository remedioRepository;
    private final SalvarRemedioUseCase salvarRemedioUseCase;

    public GaranteExistenciaRemedioUseCaseImpl(RemedioRepository remedioRepository,
                                               SalvarRemedioUseCase salvarRemedioUseCase) {

        this.remedioRepository = remedioRepository;
        this.salvarRemedioUseCase = salvarRemedioUseCase;
    }

    @Override
    public Remedio obtenhaRemedio(Integer remedioId, String remedioNome, Integer remedioDosagemMg) {
        if(remedioRepository.existe(remedioId)) {
            return remedioRepository.getRemedioPorId(remedioId);
        }
        if(remedioRepository.existePorNome(remedioNome)) {
            return remedioRepository.getRemedioPorNome(remedioNome);
        }
        return salvarRemedioUseCase.salvar(remedioNome, remedioDosagemMg);
    }
}
