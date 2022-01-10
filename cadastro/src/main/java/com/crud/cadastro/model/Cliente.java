package com.crud.cadastro.model;

import java.util.Date;
import java.util.stream.Stream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcliente")
    private Long idcliente;

    @Column(name="nomecliente")
    private String nomeCliente;

    @Column(name="sexocliente")
    private String sexoCliente;

    @Column(name="emailcliente")
    private String emailCliente;

    @Column(name="cpfcliente")
    private String cpfcliente;

    @Column(name="dtcadastro")
    private Date dtCadastroCliente;

    @Column(name="dtultimaatualiz")
    private Date dtAtualizacaoCadastroCliente;

    @Column(name="idnaturalidade ")
    private Long idNaturalidade;

    @Column(name="idnacionalidade")
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
        return this.cpfcliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfcliente = cpfCliente;
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

    public void setDtAtualizacaoCadastroCliente(Date dtAtualizacaoCadastroCliente) {
        this.dtAtualizacaoCadastroCliente = dtAtualizacaoCadastroCliente;
    }

}
