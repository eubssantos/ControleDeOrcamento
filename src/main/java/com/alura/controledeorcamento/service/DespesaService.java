package com.alura.controledeorcamento.service;

import com.alura.controledeorcamento.commands.DespesaCommand.inputs.CreateDespesaCommand;
import com.alura.controledeorcamento.commands.DespesaCommand.inputs.UpdateDespesaCommand;
import com.alura.controledeorcamento.commands.DespesaCommand.outputs.DespesaDTO;
import com.alura.controledeorcamento.entity.Despesa;
import com.alura.controledeorcamento.repository.DespesaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;

import static com.alura.controledeorcamento.enums.Categorias.OUTRAS;

@Service
@RequiredArgsConstructor
public class DespesaService {

    private final DespesaRepository despesaRepository;

    private void salvarDespesa(Despesa despesa) {despesaRepository.save(despesa);}

    public DespesaDTO criarDespesa(CreateDespesaCommand command) {
        boolean despesaJaCadastradaNoMes = despesaRepository.isDespesaJaCadastrada(command.getDescricao(), command.getData().getMonthValue(), command.getData().getYear());
        if(despesaJaCadastradaNoMes) {
            throw new ValidationException("Despesa já cadastrada no mês!");
        }

        Despesa despesa = new Despesa(command);

        if(command.getCategoria() == null) {
            command.setCategoria(OUTRAS);
        }

        this.salvarDespesa(despesa);

        return new DespesaDTO(despesa);
    }

    public Optional<Despesa> detalhamentoDeDespesa(Long documentId)  {
        return despesaRepository.findById(documentId);
    }

    public List<DespesaDTO> listagemDeDespesas(String searchDescricao) {
        List<Despesa> despesas = despesaRepository.findAllDespesas(searchDescricao);
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

            boolean despesaJaCadastradaNoMes = despesaRepository.isDespesaJaCadastrada(despesa.getDescricao(), despesa.getData().getMonthValue(), despesa.getData().getYear());
            if(despesaJaCadastradaNoMes) {
                throw new ValidationException("Despesa já cadastrada no mês!");
            }

            this.salvarDespesa(despesa);

        return new DespesaDTO(despesa);
    }

    public List<DespesaDTO> listagemDeDespesasPorMes(int mes, int ano) {
        List<Despesa> despesas = despesaRepository.listagemDeDespesasPorMes(mes, ano);
        return DespesaDTO.convert(despesas);
    }
}
