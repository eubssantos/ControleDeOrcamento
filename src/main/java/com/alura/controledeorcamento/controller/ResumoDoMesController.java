package com.alura.controledeorcamento.controller;

import com.alura.controledeorcamento.service.ResumoDoMesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("resumo")
@RequiredArgsConstructor
public class ResumoDoMesController {

    private final ResumoDoMesService resumoDoMesService;

    @GetMapping("/{mes}/{ano}")
    public ResponseEntity<?> resumoDoMes(@PathVariable int mes, @PathVariable int ano) {
        return ResponseEntity.ok(resumoDoMesService.resumoDoMes(mes, ano));
    }
}
