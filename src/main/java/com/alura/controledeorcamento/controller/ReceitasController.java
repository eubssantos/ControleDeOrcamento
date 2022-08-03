package com.alura.controledeorcamento.controller;

import com.alura.controledeorcamento.repository.entity.Receitas;
import com.alura.controledeorcamento.service.ReceitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/receitas")
public class ReceitasController {

    @Autowired
    ReceitasService receitasService;

    @GetMapping("/listagem")
    public ResponseEntity<List<Receitas>> listagemDeReceitas() {
        return ResponseEntity.ok().body(receitasService.getAll());
    }
}
