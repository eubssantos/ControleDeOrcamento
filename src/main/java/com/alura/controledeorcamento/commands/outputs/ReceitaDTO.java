package com.alura.controledeorcamento.commands.outputs;

import com.alura.controledeorcamento.entity.Receita;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ReceitaDTO {

    private String descricao;
    private LocalDate data;
    private double valor;

    public ReceitaDTO(Receita receita) {
        this.descricao = receita.getDescricao();
        this.data = receita.getData();
        this.valor = receita.getValor();
    }

    public static List<ReceitaDTO> convert(List<Receita> receitas) {
        return receitas.stream().map(ReceitaDTO::new).collect(Collectors.toList());
    }
}


