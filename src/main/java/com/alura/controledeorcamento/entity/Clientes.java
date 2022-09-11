package com.alura.controledeorcamento.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "clienteId")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;

    private String nome;
    private String cpf;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dataNascimento;
    private String telefone;
    private String email;
    private String senha;

    @OneToMany(mappedBy = "cliente")
    Set<Possuem> possuem;


    public Clientes(String nome, String cpf, Date dataNascimento, String telefone, String email, String senha, Set<Possuem> possuem) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.possuem = possuem;
    }

}
