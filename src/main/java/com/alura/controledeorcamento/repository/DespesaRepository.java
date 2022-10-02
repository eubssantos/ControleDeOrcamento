package com.alura.controledeorcamento.repository;

import com.alura.controledeorcamento.entity.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    @Query(value = "SELECT * FROM challange.despesa d WHERE ?1 IS NULL OR (d.descricao LIKE CONCAT('%', ?1, '%'))", nativeQuery = true)
    List<Despesa> findAllDespesas(String searchDescricao);

    Despesa findDespesaByDespesaId(Long id);
}
