package com.crud.cadastro.controller.dto;

public class UfResponse {
    private Long idUf;
    private String deUf;
    private String siglaUf;

    public static UfResponse converter(UfResponse uf){
        var ufresponse = new UfResponse();
        ufresponse.setIdUf(uf.getIdUf());
        ufresponse.setDeUf(uf.getDeUf());
        ufresponse.setSiglaUf(uf.getSiglaUf());
        return ufresponse;
    }

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
