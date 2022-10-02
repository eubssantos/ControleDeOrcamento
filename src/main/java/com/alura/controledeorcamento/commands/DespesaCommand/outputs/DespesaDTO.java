package com.alura.controledeorcamento.commands.DespesaCommand.outputs;

import com.alura.controledeorcamento.entity.Despesa;
import com.alura.controledeorcamento.enums.Categorias;
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
    private Categorias categoria;

    public DespesaDTO(Despesa despesa) {
        this.despesaId = despesa.getDespesaId();
        this.descricao = despesa.getDescricao();
        this.data = despesa.getData();
        this.valor = despesa.getValor();
        this.categoria = despesa.getCategoria();
    }

    public static List<DespesaDTO> convert(List<Despesa> despesas) {
        return despesas.stream().map(DespesaDTO::new).collect(Collectors.toList());
    }
}
