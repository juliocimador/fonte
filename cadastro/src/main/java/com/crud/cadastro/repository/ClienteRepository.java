package com.crud.cadastro.repository;

import java.util.List;

import com.crud.cadastro.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    public Cliente findBycpfcliente(String cpfCliente);
    
    /*public final static String PESQ_POR_CPF = "SELECT cpfcliente, idcliente " + 
                                                       "FROM Cliente " +
                                                       "WHERE cpfcliente = :cpfCliente";
    @Query(PESQ_POR_CPF)
    public Cliente findBycpfcliente(@Param("cpfCliente") String cpfCliente);
    */
}
