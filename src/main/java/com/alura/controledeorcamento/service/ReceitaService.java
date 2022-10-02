package com.alura.controledeorcamento.service;

import com.alura.controledeorcamento.commands.inputs.receita.CreateReceitaCommands;
import com.alura.controledeorcamento.commands.inputs.receita.UpdateReceitaCommand;
import com.alura.controledeorcamento.commands.outputs.ReceitaDTO;
import com.alura.controledeorcamento.entity.Receita;
import com.alura.controledeorcamento.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    private void salvarReceita(Receita receita) {receitaRepository.save(receita);}

    public ReceitaDTO criarReceita(CreateReceitaCommands command) {
        Receita receita = new Receita(command);
        this.salvarReceita(receita);

        ReceitaDTO dto = new ReceitaDTO(receita);
        return dto;
    }

    public Optional<Receita> detalhamentoDeReceita(Long receitaId)  {
        return receitaRepository.findById(receitaId);
    }

    public List<ReceitaDTO> listagemDeReceitas(String searchDescricao) {
        List<Receita> receitas = receitaRepository.findAllReceitas(searchDescricao);
        return ReceitaDTO.convert(receitas);
    }

    public void deletarReceita(Long receitaId) {
        receitaRepository.deleteById(receitaId);
    }

    public ReceitaDTO editarReceita(Long receitaId, UpdateReceitaCommand command) {
        Receita receita = receitaRepository.findReceitaByReceitaId(receitaId);
        receita.setDescricao(command.getDescricao());
        receita.setData(command.getData());
        receita.setValor(command.getValor());
        this.salvarReceita(receita);

        ReceitaDTO dto = new ReceitaDTO(receita);
        return dto;
    }
}
