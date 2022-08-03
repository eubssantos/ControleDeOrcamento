package com.alura.controledeorcamento.service;

import com.alura.controledeorcamento.entity.Receitas;
import com.alura.controledeorcamento.repository.ReceitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitasService {

    @Autowired
    ReceitasRepository receitasRepository;

    public List<Receitas> getAll() {
        return receitasRepository.findAll();
    }

    public Optional<Receitas> getById(Long id) {
        return receitasRepository.findById(id);
    }

    public Receitas create(Receitas receitas) {
        return receitasRepository.save(receitas);
    }
}
