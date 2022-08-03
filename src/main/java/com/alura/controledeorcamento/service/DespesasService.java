package com.alura.controledeorcamento.service;

import com.alura.controledeorcamento.entity.Despesas;
import com.alura.controledeorcamento.repository.DespesasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DespesasService {

    @Autowired
    DespesasRepository despesasRepository;

    public List<Despesas> getAll() {
       return despesasRepository.findAll();
    }

    public Optional<Despesas> getById(Long id) {
        return despesasRepository.findById(id);
    }

    public Despesas saveDespesas(Despesas despesas) {
        return despesasRepository.save(despesas);
    }

}
