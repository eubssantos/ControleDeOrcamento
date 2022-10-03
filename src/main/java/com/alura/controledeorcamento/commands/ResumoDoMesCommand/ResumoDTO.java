package com.alura.controledeorcamento.commands.ResumoDoMesCommand;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
public class ResumoDTO {

    private BigDecimal valorTotalReceitas;
    private BigDecimal valorTotalDespesas;
    private BigDecimal saldoFinal;
    private List<GastosPorCategoriaDTO> gastosPorCategoria;
}
