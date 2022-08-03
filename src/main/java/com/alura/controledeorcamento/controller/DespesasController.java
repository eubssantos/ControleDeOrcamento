package com.alura.controledeorcamento.controller;

import com.alura.controledeorcamento.entity.Despesas;
import com.alura.controledeorcamento.service.DespesasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/despesas")
public class DespesasController {

    @Autowired
    DespesasService despesasService;

    @GetMapping(value = "/listagem")
    public ResponseEntity<List<Despesas>> listagemDeDespesas() {
        return ResponseEntity.ok().body(despesasService.getAll());
    }

    @GetMapping(value = "/listagem/{id}")
    public ResponseEntity<Optional<Despesas>> detalhamentoDeDespesa(@PathVariable Long id) {
        return ResponseEntity.ok().body(despesasService.getById(id));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Despesas> cadastroDeDespesas(@RequestBody Despesas despesas) {
        return ResponseEntity.ok().body(despesasService.saveDespesas(despesas));
    }

}
