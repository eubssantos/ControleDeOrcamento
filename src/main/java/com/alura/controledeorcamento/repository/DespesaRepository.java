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

    @Query("SELECT CASE WHEN COUNT(d) > 0 THEN TRUE ELSE FALSE END FROM Despesa d WHERE d.descricao = :descricao AND MONTH(d.data) = :mes AND YEAR(d.data) = :ano")
    boolean isDespesaJaCadastrada(String descricao, int mes, int ano);

    @Query(value = "SELECT * FROM challange.despesa d WHERE MONTH(d.data) = ?1 AND YEAR(d.data) = ?2", nativeQuery = true)
    List<Despesa> listagemDeDespesasPorMes(int mes, int ano);

    Despesa findDespesaByDespesaId(Long id);
}
