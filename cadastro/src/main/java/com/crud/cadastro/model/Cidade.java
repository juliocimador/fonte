package com.crud.cadastro.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cidades")
public class Cidade{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcidade")
    private Long idcidade;

    @Column(name="decidade")
    private String decidade;

    public Long getIdcidade() {
        return this.idcidade;
    }

    public void setIdcidade(Long idcidade) {
        this.idcidade = idcidade;
    }

    public String getDecidade() {
        return this.decidade;
    }

    public void setDecidade(String decidade) {
        this.decidade = decidade;
    }
}