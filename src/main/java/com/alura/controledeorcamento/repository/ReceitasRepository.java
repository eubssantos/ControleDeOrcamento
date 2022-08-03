package com.alura.controledeorcamento.repository;

import com.alura.controledeorcamento.entity.Receitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitasRepository extends JpaRepository<Receitas, Long> {

}

