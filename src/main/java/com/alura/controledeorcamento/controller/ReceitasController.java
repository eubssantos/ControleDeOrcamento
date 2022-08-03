package com.alura.controledeorcamento.controller;

import com.alura.controledeorcamento.service.ReceitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/receitas")
public class ReceitasController {

    @Autowired
    ReceitasService receitasService;

    @GetMapping("/listagem")
    public ResponseEntity<?> listagemDeReceitas() {
        return ResponseEntity.ok(receitasService.listagemDeReceitas());
    }
}
