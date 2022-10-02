package com.alura.controledeorcamento.controller;

import com.alura.controledeorcamento.commands.inputs.despesa.CreateDespesaCommand;
import com.alura.controledeorcamento.commands.inputs.despesa.UpdateDespesaCommand;
import com.alura.controledeorcamento.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("despesa")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @PostMapping("criarDespesa")
    public ResponseEntity<?> criarDespesa(@RequestBody @Valid CreateDespesaCommand command) {
        return ResponseEntity.ok(despesaService.criarDespesa(command));
    }

    @GetMapping("detalhamentoDeDespesa/{despesaId}")
    public ResponseEntity<?> detalhamentoDeDespesa(@PathVariable Long despesaId) {
        return ResponseEntity.ok(despesaService.detalhamentoDeDespesa(despesaId));
    }

    @GetMapping("listagemDeDespesas")
    public ResponseEntity<?> listagemDeDespesas() {
        return ResponseEntity.ok((despesaService.listagemDeDespesas()));
    }

    @PutMapping("editarDespesa/{despesaId}")
    public ResponseEntity<?> editarDespesa(
            @PathVariable Long despesaId,
            @RequestBody @Valid UpdateDespesaCommand command) {
        return ResponseEntity.ok(despesaService.editarDespesa(despesaId, command));
    }

    @DeleteMapping("deletarDespesa/{despesaId}")
    public ResponseEntity<?> deletarDespesa(@PathVariable Long despesaId) {
        despesaService.deletarDespesa(despesaId);
        return ResponseEntity.ok().build();
    }


}
