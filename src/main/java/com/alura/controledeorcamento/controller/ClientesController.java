package com.alura.controledeorcamento.controller;

import com.alura.controledeorcamento.entity.Clientes;
import com.alura.controledeorcamento.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClientesRepository clientesRepository;

    // create JPA
    @PostMapping("/cliente/form/save")
    public Clientes saveCliente(@RequestBody Clientes cliente) {
        return clientesRepository.save(cliente);
    }

    // readAll JPA
    @GetMapping("/cliente")
    public List<Clientes> readAllCliente() {
        return clientesRepository.findAll();
    }

    // readById JPA
    @GetMapping("/cliente/{id}")
    public Clientes readByIdCliente(@PathVariable Long id) {
        Optional<Clientes> cliente = clientesRepository.findById(id);
        if (cliente.isPresent()) {
            return cliente.get();
        } else {
            throw new RuntimeException("Cliente não encontrado pelo id: " + id);
        }
    }

    // update JPA
    @PutMapping("/updateCliente")
    public Clientes updateCliente(@RequestBody Clientes cliente) {
        return clientesRepository.save(cliente);
    }

    // delete JPA
    @DeleteMapping("/cliente/{id}")
    public String deleteCliente(@PathVariable Long id) {
        Optional<Clientes> cliente = clientesRepository.findById(id);
        if (cliente.isPresent()) {
            clientesRepository.delete(cliente.get());
            return "Cliente deletado com sucesso, id: " + id;
        } else {
            throw new RuntimeException("Cliente não encontrado pelo id: " + id);
        }
    }

    @GetMapping("/cliente/form/add")
    public ModelAndView getFormadd() {
        ModelAndView mv = new ModelAndView("cadastro");
        return mv;

    }

}
