package com.alura.controledeorcamento.entity;

import com.alura.controledeorcamento.commands.inputs.despesa.CreateDespesaCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    public Despesa(CreateDespesaCommand command) {
        this.descricao = command.getDescricao();
        this.data = command.getData();
        this.valor = command.getValor();
    }

}
