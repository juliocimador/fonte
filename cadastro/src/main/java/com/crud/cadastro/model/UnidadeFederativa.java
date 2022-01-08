package com.crud.cadastro.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="uf")
public class UnidadeFederativa {
    @Id
    private Long idUf;
    private String deUf;
    private String siglaUf;

    public Long getIdUf() {
        return this.idUf;
    }

    public void setIdUf(Long idUf) {
        this.idUf = idUf;
    }

    public String getDeUf() {
        return this.deUf;
    }

    public void setDeUf(String deUf) {
        this.deUf = deUf;
    }

    public String getSiglaUf() {
        return this.siglaUf;
    }

    public void setSiglaUf(String siglaUf) {
        this.siglaUf = siglaUf;
    }
}
