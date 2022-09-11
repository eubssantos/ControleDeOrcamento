package com.alura.controledeorcamento.repository;

import com.alura.controledeorcamento.entity.Possuem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PossuemRepository extends JpaRepository<Possuem, Long> {


        @Query(value = "SELECT cli.*, en.rua, en.bairro, pos.numero, en.cidade, en.estado, en.cep, pos.complemento, pos.tipo, en.pais FROM clientes cli"
                + "INNER JOIN possuem pos on pos.cliente_fk = cli.id"
                + "INNER JOIN enderecos en on pos.endereco_fk = en.id;", nativeQuery = true)
        Optional<Possuem> findAllByPossuem();

        @Query(value = "INSERT INTO public.possuem (possuem_id, complemento, numero, tipo, cliente_fk, endereco_fk) VALUES (10, 'Casa', 53, 0, 2, 3);", nativeQuery = true)
        void insertPossuem();
    }
