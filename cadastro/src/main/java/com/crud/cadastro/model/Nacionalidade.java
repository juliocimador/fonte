package com.crud.cadastro.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="nacionalidade")
public class Nacionalidade {
    @Id
    private Long idNacionalidade;
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
