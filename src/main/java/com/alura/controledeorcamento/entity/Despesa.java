package com.alura.controledeorcamento.entity;

import com.alura.controledeorcamento.commands.DespesaCommand.inputs.CreateDespesaCommand;
import com.alura.controledeorcamento.enums.Categorias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long despesaId;
    private String descricao;
    private LocalDate data;
    private double valor;
    @Enumerated(EnumType.STRING)
    private Categorias categoria;

    public Despesa(CreateDespesaCommand command) {
        this.descricao = command.getDescricao();
        this.data = command.getData();
        this.valor = command.getValor();
        this.categoria = command.getCategoria();
    }

}
