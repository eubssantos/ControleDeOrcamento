package com.alura.controledeorcamento.commands.inputs.despesa;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateDespesaCommand {

    private String descricao;
    @JsonFormat(pattern ="dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate data;
    private double valor;

}
