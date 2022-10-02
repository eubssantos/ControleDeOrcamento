package com.alura.controledeorcamento.commands.inputs.receita;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateReceitaCommands {

    private String descricao;
    @JsonFormat(pattern ="dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate data;
    private double valor;

}
