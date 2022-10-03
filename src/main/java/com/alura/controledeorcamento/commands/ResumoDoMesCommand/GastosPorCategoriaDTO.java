package com.alura.controledeorcamento.commands.ResumoDoMesCommand;

import com.alura.controledeorcamento.enums.Categorias;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class GastosPorCategoriaDTO {

    private Categorias categoria;
    private Double valorTotal;

}
