package com.thiago.faker.model.dto;

public class RbrfCpfDto {

    private String cpf;
    private Integer codigo;
    private String mensagem;
    private DadosDto dados;

    public RbrfCpfDto() {
    }

    public RbrfCpfDto(String cpf, Integer codigo, String mensagem, DadosDto dados) {
        this.cpf = cpf;
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.dados = dados;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public DadosDto getDados() {
        return dados;
    }

    public void setDados(DadosDto dados) {
        this.dados = dados;
    }
}
