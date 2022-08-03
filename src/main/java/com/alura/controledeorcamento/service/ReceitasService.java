package com.alura.controledeorcamento.service;

import com.alura.controledeorcamento.repository.entity.Receitas;
import com.alura.controledeorcamento.repository.ReceitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitasService {

    @Autowired
    ReceitasRepository receitasRepository;

    public List<Receitas> getAll() {
        List<Receitas> lista = receitasRepository.findAll();
        return lista;
    }
}
