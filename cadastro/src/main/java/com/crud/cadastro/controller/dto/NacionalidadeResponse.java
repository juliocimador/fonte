package com.crud.cadastro.controller.dto;

public class NacionalidadeResponse {
    private Long idNacionalidade;
    private String deNacionalidade;

    public static NacionalidadeResponse converter(NacionalidadeResponse n){
        var nacionalidade = new NacionalidadeResponse();
        nacionalidade.setIdNacionalidade(n.getIdNacionalidade());
        nacionalidade.setDeNacionalidade(n.getDeNacionalidade());
        return nacionalidade;
    }

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
