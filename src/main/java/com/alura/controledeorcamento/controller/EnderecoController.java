package com.alura.controledeorcamento.controller;


import com.alura.controledeorcamento.entity.Endereco;
import com.alura.controledeorcamento.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

        @Autowired
        private EnderecoRepository enderecoDao;

        // create JPA
        @PostMapping("/endereco/form/save")
        public Endereco saveEnderecoCliente(@RequestBody Endereco endereco) {
            return enderecoDao.save(endereco);
        }

        // readAll JPA
        @GetMapping("/endereco")
        public List<Endereco> readAllEnderecoCliente() {
            return enderecoDao.findAll();
        }

        // readById JPA
        @GetMapping("/endereco/{id}")
        public Endereco readByIdEnderecoCliente(@PathVariable Long id) {
            Optional<Endereco> endereco = enderecoDao.findById(id);
            if (endereco.isPresent()) {
                return endereco.get();
            } else {
                throw new RuntimeException("Endereco não encontrado pelo id: " + id);
            }
        }

        // update JPA
        @PutMapping("/endereco")
        public Endereco updateEnderecoCliente(@RequestBody Endereco endereco) {
            return enderecoDao.save(endereco);
        }

        // delete JPA
        @DeleteMapping("/endereco/{id}")
        public String deleteCliente(@PathVariable Long id) {
            Optional<Endereco> endereco = enderecoDao.findById(id);
            if (endereco.isPresent()) {
                enderecoDao.delete(endereco.get());
                return "Endereco deletado com sucesso, id: " + id;
            } else {
                throw new RuntimeException("Endereco não encontrado pelo id: " + id);
            }
        }

        @GetMapping("/endereco/form/add")
        public ModelAndView getFormadd() {
            ModelAndView mv = new ModelAndView("cadastro");
            return mv;

        }

}
