package com.alura.controledeorcamento.controller;

import com.alura.controledeorcamento.entity.Receitas;
import com.alura.controledeorcamento.service.ReceitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/receitas")
public class ReceitasController {

    @Autowired
    ReceitasService receitasService;

    @GetMapping("/listagem")
    public ResponseEntity<List<Receitas>> listagemDeReceitas() {
        return ResponseEntity.ok().body(receitasService.getAll());
    }

    @GetMapping(value = "/listagem/{id}")
    public ResponseEntity<Optional<Receitas>> detalhamentoDeReceita(@PathVariable Long id) {
        return ResponseEntity.ok().body(receitasService.getById(id));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Receitas> cadastroDeReceitas(@RequestBody Receitas receitas) {
        return ResponseEntity.ok().body(receitasService.create(receitas));
    }
}
