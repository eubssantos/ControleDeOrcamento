package com.alura.controledeorcamento.commands.ReceitaCommand.inputs;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class UpdateReceitaCommand {

        @NotEmpty(message = "descrição é obrigatória")
        private String descricao;

        @JsonFormat(pattern ="dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
        @NotNull(message = "data é obrigatória")
        private LocalDate data;

        @NotNull(message = "valor é obrigatório")
        private double valor;
}