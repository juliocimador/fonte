package com.crud.cadastro.repository;

import java.util.List;
import java.util.Optional;

import com.crud.cadastro.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    List<Cliente> findBycpfcliente(String cpf);

    List<Cliente> findBynomeClienteContains(String nome);
    

    @Query(
        value="Select C from Cliente as C where C.nomeCliente = ?1"
    )
    Cliente buscarClientePorNome(String nome);

}
