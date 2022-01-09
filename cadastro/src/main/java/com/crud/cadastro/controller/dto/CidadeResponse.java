package com.crud.cadastro.controller.dto;

import com.crud.cadastro.model.Cidade;

public class CidadeResponse {
    private Long idcidade;
    private String decidade;


    public static CidadeResponse converter(Cidade c){
        var cidade = new CidadeResponse();
        cidade.setIdcidade(c.getIdcidade());
        cidade.setDecidade(c.getDecidade());
        return cidade;
    }

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
