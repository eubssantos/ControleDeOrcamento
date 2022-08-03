package com.alura.controledeorcamento.controller;

import com.alura.controledeorcamento.repository.entity.Despesas;
import com.alura.controledeorcamento.service.DespesasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/despesas")
public class DespesasController {

    @Autowired
    DespesasService despesasService;

    @GetMapping(value = "/listagem")
    public ResponseEntity<List<Despesas>> listagemDeDespesas() {
        return ResponseEntity.ok().body(despesasService.getAll());
    }

}
