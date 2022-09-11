package com.alura.controledeorcamento.service;

import com.alura.controledeorcamento.entity.Clientes;
import com.alura.controledeorcamento.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    public Clientes saveCliente(Clientes clientes) {
        return clientesRepository.save(clientes);
    }

    public List<Clientes> findClientes() {
        return clientesRepository.findAll();
    }

}

