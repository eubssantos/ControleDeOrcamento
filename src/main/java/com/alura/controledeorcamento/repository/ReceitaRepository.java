package com.alura.controledeorcamento.repository;

import com.alura.controledeorcamento.entity.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    @Query(value = "SELECT * FROM challange.receita r WHERE ?1 IS NULL OR (r.descricao LIKE CONCAT('%', ?1, '%'))", nativeQuery = true)
    List<Receita> findAllReceitas(String searchDescricao);

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN TRUE ELSE FALSE END FROM Receita r WHERE r.descricao = :descricao AND MONTH(r.data) = :mes AND YEAR(r.data) = :ano")
    boolean isReceitaJaCadastrada(String descricao, Integer mes, Integer ano);

    @Query(value = "SELECT * FROM challange.receita r WHERE MONTH(r.data) = ?1 AND YEAR(r.data) = ?2", nativeQuery = true)
    List<Receita> listagemDeReceitasPorMes(Integer mes, Integer ano);

    @Query(value = "SELECT SUM(valor) FROM receita r WHERE MONTH(r.data) = ?1 AND YEAR(r.data) = ?2", nativeQuery = true)
    BigDecimal valorTotalReceitasNoMes(Integer mes, Integer ano);

    Receita findReceitaByReceitaId(Long receitaId);
}
