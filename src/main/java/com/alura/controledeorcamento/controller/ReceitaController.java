package com.alura.controledeorcamento.controller;

import com.alura.controledeorcamento.commands.inputs.receita.CreateReceitaCommands;
import com.alura.controledeorcamento.commands.inputs.receita.UpdateReceitaCommand;
import com.alura.controledeorcamento.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("receita")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @PostMapping("criarReceita")
    public ResponseEntity<?> criarReceita(@RequestBody @Valid CreateReceitaCommands command) {
        return ResponseEntity.ok(receitaService.criarReceita(command));
    }

    @GetMapping("detalhamentoDeReceita/{receitaId}")
    public ResponseEntity<?> detalhamentoDeReceita(@PathVariable Long receitaId) {
        return ResponseEntity.ok(receitaService.detalhamentoDeReceita(receitaId));
    }

    @GetMapping("listagemDeReceitas")
    public ResponseEntity<?> listagemDeReceitas(@RequestParam(defaultValue = "") String searchDescricao) {
        return ResponseEntity.ok((receitaService.listagemDeReceitas(searchDescricao)));
    }

    @PutMapping("editarReceita/{receitaId}")
    public ResponseEntity<?> editarReceita(
            @PathVariable Long receitaId,
            @RequestBody @Valid UpdateReceitaCommand command) {
        return ResponseEntity.ok(receitaService.editarReceita(receitaId, command));
    }

    @DeleteMapping("deletarReceita/{receitaId}")
    public ResponseEntity<?> deletarReceita(@PathVariable Long receitaId) {
        receitaService.deletarReceita(receitaId);
        return ResponseEntity.ok().build();
    }

}
