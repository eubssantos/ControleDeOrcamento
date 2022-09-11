package com.alura.controledeorcamento.repository;

import com.alura.controledeorcamento.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {}

