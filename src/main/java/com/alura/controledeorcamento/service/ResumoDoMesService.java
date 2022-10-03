package com.alura.controledeorcamento.service;

import com.alura.controledeorcamento.commands.ResumoDoMesCommand.GastosPorCategoriaDTO;
import com.alura.controledeorcamento.commands.ResumoDoMesCommand.ResumoDTO;
import com.alura.controledeorcamento.repository.DespesaRepository;
import com.alura.controledeorcamento.repository.ReceitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumoDoMesService {

    private final DespesaRepository despesaRepository;
    private final ReceitaRepository receitaRepository;

    public ResumoDTO resumoDoMes(Integer mes, Integer ano) {
        BigDecimal valorTotalReceitas = receitaRepository.valorTotalReceitasNoMes(mes, ano);
        BigDecimal valorTotalDespesas = despesaRepository.valorTotalDespesasNoMes(mes, ano);
        BigDecimal saldoFinal = valorTotalReceitas.subtract(valorTotalDespesas);
        List<GastosPorCategoriaDTO> gastosPorCategoria  = despesaRepository.gastosPorCategoria(mes, ano);
        return new ResumoDTO(valorTotalReceitas, valorTotalDespesas, saldoFinal, gastosPorCategoria);
    }
}
