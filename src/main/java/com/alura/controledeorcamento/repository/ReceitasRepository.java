package com.alura.controledeorcamento.repository;

import com.alura.controledeorcamento.entity.Receitas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitasRepository extends JpaRepository<Receitas, Long> {
}
