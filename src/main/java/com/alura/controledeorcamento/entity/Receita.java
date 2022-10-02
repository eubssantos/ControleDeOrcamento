package com.alura.controledeorcamento.entity;

import com.alura.controledeorcamento.commands.inputs.receita.CreateReceitaCommands;
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
@NoArgsConstructor
@AllArgsConstructor
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long receitaId;
    private String descricao;
    private LocalDate data;
    private double valor;

    public Receita(CreateReceitaCommands command) {
        this.descricao = command.getDescricao();
        this.data = command.getData();
        this.valor = command.getValor();
    }


}
