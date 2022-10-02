package com.alura.controledeorcamento.service;

import com.alura.controledeorcamento.commands.ReceitaCommand.inputs.CreateReceitaCommands;
import com.alura.controledeorcamento.commands.ReceitaCommand.inputs.UpdateReceitaCommand;
import com.alura.controledeorcamento.commands.ReceitaCommand.outputs.ReceitaDTO;
import com.alura.controledeorcamento.entity.Receita;
import com.alura.controledeorcamento.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    private void salvarReceita(Receita receita) {receitaRepository.save(receita);}

    public ReceitaDTO criarReceita(CreateReceitaCommands command) {
        boolean receitaJaCadastradaNoMes = receitaRepository.isReceitaJaCadastrada(command.getDescricao(), command.getData().getMonthValue(), command.getData().getYear());
        if(receitaJaCadastradaNoMes) {
            throw new ValidationException("Receita já cadastrada no mês!");
        }

        Receita receita = new Receita(command);
        this.salvarReceita(receita);

        return new ReceitaDTO(receita);
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

        boolean receitaJaCadastradaNoMes = receitaRepository.isReceitaJaCadastrada(receita.getDescricao(), receita.getData().getMonthValue(), receita.getData().getYear());
        if(receitaJaCadastradaNoMes) {
            throw new ValidationException("Receita já cadastrada no mês!");
        }

        this.salvarReceita(receita);

        return new ReceitaDTO(receita);
    }
}
