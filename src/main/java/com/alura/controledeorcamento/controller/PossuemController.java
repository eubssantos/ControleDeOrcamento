package com.alura.controledeorcamento.controller;

import com.alura.controledeorcamento.entity.Clientes;
import com.alura.controledeorcamento.entity.Possuem;
import com.alura.controledeorcamento.repository.ClientesRepository;
import com.alura.controledeorcamento.repository.EnderecoRepository;
import com.alura.controledeorcamento.repository.PossuemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@RestController
public class PossuemController {

    @Autowired
    private ClientesRepository clienteDao;

    @Autowired
    private EnderecoRepository enderecoDao;

    @Autowired
    private PossuemRepository enderecoClienteDao;

    // create JPA
    @PostMapping("/enderecocliente/form/save")
    public Possuem saveCliente(@RequestBody Possuem enderecoCliente) {
        return enderecoClienteDao.save(enderecoCliente);
    }

    // readAll JPA
    @GetMapping("/enderecocliente")
    public List<Possuem> readAllEnderecoCliente() {
        return enderecoClienteDao.findAll();
    }

    // readAll JPA
    @GetMapping("/possuem")
    public Optional<Possuem> findAllByPossuem() {
        return enderecoClienteDao.findAllByPossuem();
    }

    // readById JPA
    @GetMapping("/enderecocliente/{id}")
    public Possuem readByIdEnderecoCliente(@PathVariable Long id) {
        Optional<Possuem> enderecoCliente = enderecoClienteDao.findById(id);
        if (enderecoCliente.isPresent()) {
            return enderecoCliente.get();
        } else {
            throw new RuntimeException("EnderecoCliente não encontrado pelo id: " + id);
        }
    }

    // update JPA
    @PutMapping("/enderecocliente")
    public Possuem updateEnderecoCliente(@RequestBody Possuem enderecoCliente) {
        return enderecoClienteDao.save(enderecoCliente);
    }

    // delete JPA
    @DeleteMapping("/enderecocliente/{id}")
    public String deleteCliente(@PathVariable Long id) {
        Optional<Possuem> enderecoCliente = enderecoClienteDao.findById(id);
        if (enderecoCliente.isPresent()) {
            enderecoClienteDao.delete(enderecoCliente.get());
            return "EnderecoCliente deletado com sucesso, id: " + id;
        } else {
            throw new RuntimeException("EnderecoCliente não encontrado pelo id: " + id);
        }
    }

    @GetMapping("/enderecocliente/form/add")
    public ModelAndView getFormadd() {
        ModelAndView mv = new ModelAndView("cadastro");
        return mv;

    }

}
