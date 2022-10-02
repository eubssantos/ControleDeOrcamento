package com.alura.controledeorcamento.service;

import com.alura.controledeorcamento.commands.inputs.despesa.CreateDespesaCommand;
import com.alura.controledeorcamento.commands.inputs.despesa.UpdateDespesaCommand;
import com.alura.controledeorcamento.commands.outputs.DespesaDTO;
import com.alura.controledeorcamento.entity.Despesa;
import com.alura.controledeorcamento.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    private void salvarDespesa(Despesa despesa) {despesaRepository.save(despesa);}

    public DespesaDTO criarDespesa(CreateDespesaCommand command) {
        Despesa despesa = new Despesa(command);
        this.salvarDespesa(despesa);

        DespesaDTO dto = new DespesaDTO(despesa);
        return dto;
    }

    public Optional<Despesa> detalhamentoDeDespesa(Long documentId)  {
        return despesaRepository.findById(documentId);
    }

    public List<DespesaDTO> listagemDeDespesas() {
        List<Despesa> despesas = despesaRepository.findAll();
        return DespesaDTO.convert(despesas);
    }

    public void deletarDespesa(Long documentId) {
        despesaRepository.deleteById(documentId);
    }

    public DespesaDTO editarDespesa(Long despesaId, UpdateDespesaCommand command) {
            Despesa despesa = despesaRepository.findDespesaByDespesaId(despesaId);
            despesa.setDescricao(command.getDescricao());
            despesa.setData(command.getData());
            despesa.setValor(command.getValor());
            this.salvarDespesa(despesa);

            DespesaDTO dto = new DespesaDTO(despesa);
            return dto;
    }

}
