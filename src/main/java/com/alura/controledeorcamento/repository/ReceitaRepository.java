package com.alura.controledeorcamento.repository;

import com.alura.controledeorcamento.entity.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    Receita findReceitaByReceitaId(Long receitaId);
}
