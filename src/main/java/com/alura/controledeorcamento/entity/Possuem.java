package com.alura.controledeorcamento.entity;

import ENUM.TipoEndereco;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "possuemId")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Possuem {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long possuemId;

        private Integer numero;
        private String complemento;
        private TipoEndereco tipo;
        @ManyToOne(fetch = FetchType.LAZY)
        private Clientes cliente;

        @ManyToOne(fetch = FetchType.LAZY)
        private Endereco endereco;


        public Possuem(Integer numero, String complemento, TipoEndereco tipo, Clientes cliente, Endereco endereco) {
            this.numero = numero;
            this.complemento = complemento;
            this.tipo = tipo;
            this.cliente = cliente;
            this.endereco = endereco;
        }

}
