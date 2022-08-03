package com.alura.controledeorcamento.repository;

import com.alura.controledeorcamento.entity.Despesas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesasRepository extends JpaRepository<Despesas, Long> {

}
