package com.crud.cadastro.controller.dto;

import com.crud.cadastro.model.Usuario;

//responsavel para responder o meu serviço sem apresentar a logica
public class UsuarioResponse {

    private Long idUsuario;
    private String nmUsuario;
    private String cpfUsuario;
    private String emailUsuario;
    //private String senhaUsuario;

    public static UsuarioResponse converter(Usuario u){
        var usuario = new UsuarioResponse();
        usuario.setIdUsuario(u.getIdUsuario());
        usuario.setCpfUsuario(u.getCpfUsuario());
        usuario.setEmailUsuario(u.getEmailUsuario());
        usuario.setNmUsuario(u.getNmUsuario());
        //usuario.setSenhaUsuario(u.getSenhaUsuario()); Não retornar senha do usuário
        return usuario;
    }

    public Long getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNmUsuario() {
        return this.nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public String getCpfUsuario() {
        return this.cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public String getEmailUsuario() {
        return this.emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }
    /*
    public String getSenhaUsuario() {
        return this.senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }
    */
    
}
