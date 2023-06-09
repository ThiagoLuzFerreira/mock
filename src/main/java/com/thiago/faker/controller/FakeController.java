package com.thiago.faker.controller;

import com.thiago.faker.model.Dados;
import com.thiago.faker.model.RbrfCpf;
import com.thiago.faker.model.dto.DadosDto;
import com.thiago.faker.model.dto.RbrfCpfDto;
import com.thiago.faker.repository.RbrfRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/rbrf")
public class FakeController {

    private final RbrfRepository repository;

    public FakeController(RbrfRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<RbrfCpfDto>> listAll(){

        List<RbrfCpf> rbrfCpfList = repository.findAll();
        List<RbrfCpfDto> rbrfCpfDtoList = rbrfCpfList.stream().map(rbrfCpf -> converter(rbrfCpf)).collect(Collectors.toList());

        return ResponseEntity.ok(rbrfCpfDtoList);
    }

    private RbrfCpfDto converter(RbrfCpf rbrfCpf){
        RbrfCpfDto rbrfCpfDto = new RbrfCpfDto();
        rbrfCpfDto.setCpf(rbrfCpf.getCpf());
        rbrfCpfDto.setCodigo(rbrfCpf.getCodigo());
        rbrfCpfDto.setMensagem(rbrfCpf.getMensagem());
        rbrfCpfDto.setDados(converter(rbrfCpf.getDados()));
        return rbrfCpfDto;
    }

    private DadosDto converter(Dados dados) {
        DadosDto dadosDto = new DadosDto();
        dadosDto.setCodSituacaoReceita(dados.getCodSituacaoReceita());
        dadosDto.setDescSituacaoReceita(dados.getDescSituacaoReceita());
        dadosDto.setDataConsulta(dados.getDataConsulta());
        dadosDto.setNome(dados.getNome());
        dadosDto.setDtNascimento(dados.getDtNascimento());
        dadosDto.setSexo(dados.getSexo());
        dadosDto.setNomeMae(dados.getNomeMae());
        dadosDto.setTituloEleitor(dados.getTituloEleitor());
        dadosDto.setResideExterior(dados.getResideExterior());
        dadosDto.setAnoObito(dados.getAnoObito());
        dadosDto.setDtAtualizacao(dados.getDtAtualizacao());
        dadosDto.setIsClienteValido(dados.getIsClienteValido());
        dadosDto.setIsNomeValido(dados.getIsNomeValido());
        dadosDto.setIsDataNascimentoValida(dados.getIsDataNascimentoValida());
        return dadosDto;
    }

}