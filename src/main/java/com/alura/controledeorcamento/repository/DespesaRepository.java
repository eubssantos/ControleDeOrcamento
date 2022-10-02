package com.alura.controledeorcamento.repository;

import com.alura.controledeorcamento.entity.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    Despesa findDespesaByDespesaId(Long id);
}
