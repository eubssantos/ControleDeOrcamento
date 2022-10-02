package com.alura.controledeorcamento.commands.outputs;

import com.alura.controledeorcamento.entity.Despesa;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class DespesaDTO {
    private Long despesaId;
    private String descricao;
    private LocalDate data;
    private double valor;

    public DespesaDTO(Despesa despesa) {
        this.despesaId = despesa.getDespesaId();
        this.descricao = despesa.getDescricao();
        this.data = despesa.getData();
        this.valor = despesa.getValor();
    }

    public static List<DespesaDTO> convert(List<Despesa> despesas) {
        return despesas.stream().map(DespesaDTO::new).collect(Collectors.toList());
    }
}
