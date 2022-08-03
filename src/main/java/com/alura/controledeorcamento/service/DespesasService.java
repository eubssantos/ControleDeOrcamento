package com.alura.controledeorcamento.service;

import com.alura.controledeorcamento.repository.entity.Despesas;
import com.alura.controledeorcamento.repository.DespesasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespesasService {

    @Autowired
    DespesasRepository despesasRepository;

    public List<Despesas> getAll() {
        List<Despesas> list = despesasRepository.findAll();
       return list;
    }

}
