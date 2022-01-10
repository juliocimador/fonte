package com.crud.cadastro.repository;

import com.crud.cadastro.model.Cliente;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;


@Repository
public class ClienteCustomRepository {
    
    private final EntityManager em;

    public ClienteCustomRepository(EntityManager em) {
        this.em = em;
    }


    public List<Cliente> find(Long id, String nome, String cpf){
        String query = "select c from Cliente as c";
        String condicao = " where ";

        if(id != null){
            query += condicao + "c.idcliente = :id";
            condicao = " and ";
        }
        if(nome != null){
            query += condicao + "c.nomeCliente = :nome";
            condicao = " and ";
        }        
        if(cpf != null){
            query += condicao + "c.cpfcliente = :cpf";
            condicao = " and ";
        }
                  
        var q = em.createQuery(query,Cliente.class);     

        if(id != null){
            q.setParameter("id", id);
        }
        if(nome != null){
            q.setParameter("nome", nome);
        }        
        if(cpf != null){
            q.setParameter("cpf", cpf);
        }           
        return q.getResultList();
    }
}
