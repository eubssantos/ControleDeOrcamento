package com.alura.controledeorcamento.service;


import com.alura.controledeorcamento.entity.Endereco;
import com.alura.controledeorcamento.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco save(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco saveEndereco(Endereco endereco) {
        return save(endereco);
    }

    public List<Endereco> listarTodosOsEnderecos() {
        return enderecoRepository.findAll();
    }

}
