package com.crud.cadastro.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
    @Id
    private Long idcliente;
    private String nomeCliente;
    private String sexoCliente;
    private String emailCliente;
    private String cpfCliente;
    private String dtCadastroCliente;
    private String dtAtualizacaoCadastroCliente;

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

    public String getDtCadastroCliente() {
        return this.dtCadastroCliente;
    }

    public void setDtCadastroCliente(String dtCadastroCliente) {
        this.dtCadastroCliente = dtCadastroCliente;
    }

    public String getDtAtualizacaoCadastroCliente() {
        return this.dtAtualizacaoCadastroCliente;
    }

    public void setDtAtualizacaoCadastroCliente(String dtAtualizacaoCadastroCliente) {
        this.dtAtualizacaoCadastroCliente = dtAtualizacaoCadastroCliente;
    }
    
}
