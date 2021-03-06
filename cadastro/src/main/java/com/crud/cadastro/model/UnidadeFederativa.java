package com.crud.cadastro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="uf")
public class UnidadeFederativa {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="iduf")
    private Long idUf;

    @Column(name="deuf")
    private String deUf;

    @Column(name="siglauf")
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
