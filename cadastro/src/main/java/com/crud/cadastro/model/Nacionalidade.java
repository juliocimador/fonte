package com.crud.cadastro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="nacionalidade")
public class Nacionalidade {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idnacionalidade")
    private Long idNacionalidade;

    @Column(name="deNacionalidade")
    private String deNacionalidade;

    public Long getIdNacionalidade() {
        return this.idNacionalidade;
    }

    public void setIdNacionalidade(Long idNacionalidade) {
        this.idNacionalidade = idNacionalidade;
    }

    public String getDeNacionalidade() {
        return this.deNacionalidade;
    }

    public void setDeNacionalidade(String deNacionalidade) {
        this.deNacionalidade = deNacionalidade;
    }

}
