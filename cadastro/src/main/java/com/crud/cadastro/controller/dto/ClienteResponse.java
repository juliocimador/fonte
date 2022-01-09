package com.crud.cadastro.controller.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.crud.cadastro.model.Cliente;

import org.hibernate.validator.constraints.Length;

public class ClienteResponse {

    private Long idcliente;
    /*@NotBlank
    @Length
    */
    private String nomeCliente;
    private String sexoCliente;
    private String emailCliente;
    private String cpfCliente;
    private Date dtCadastroCliente;
    private Date dtAtualizacaoCadastroCliente;
    private Long idNaturalidade;
    private Long idNacionalidade;

    public Long getIdNaturalidade() {
        return this.idNaturalidade;
    }

    public void setIdNaturalidade(Long idNaturalidade) {
        this.idNaturalidade = idNaturalidade;
    }

    public Long getIdNacionalidade() {
        return this.idNacionalidade;
    }

    public void setIdNacionalidade(Long idNacionalidade) {
        this.idNacionalidade = idNacionalidade;
    }

    public static ClienteResponse converter(Cliente cli){
        var cliente = new ClienteResponse();
        cliente.setIdcliente(cli.getIdcliente());
        cliente.setNomeCliente(cli.getNomeCliente());
        cliente.setSexoCliente(cli.getSexoCliente());
        cliente.setEmailCliente(cli.getEmailCliente());
        cliente.setCpfCliente(cli.getCpfCliente());
        cliente.setDtCadastroCliente(cli.getDtCadastroCliente());
        cliente.setDtAtualizacaoCadastroCliente(cli.getDtAtualizacaoCadastroCliente());
        return cliente;
    }

    public Long getIdcliente() {
        return this.idcliente;
    }

    public void setIdcliente(Long idcliente) {
        this.idcliente = idcliente;
    }

    public String getNomeCliente() {
        return this.nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getSexoCliente() {
        return this.sexoCliente;
    }

    public void setSexoCliente(String sexoCliente) {
        this.sexoCliente = sexoCliente;
    }

    public String getEmailCliente() {
        return this.emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getCpfCliente() {
        return this.cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public Date getDtCadastroCliente() {
        return this.dtCadastroCliente;
    }

    public void setDtCadastroCliente(Date dtCadastroCliente) {
        this.dtCadastroCliente = dtCadastroCliente;
    }

    public Date getDtAtualizacaoCadastroCliente() {
        return this.dtAtualizacaoCadastroCliente;
    }

    public void setDtAtualizacaoCadastroCliente(Date date) {
        this.dtAtualizacaoCadastroCliente = date;
    }
}
