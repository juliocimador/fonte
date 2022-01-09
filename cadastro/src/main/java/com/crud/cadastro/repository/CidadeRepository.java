package com.crud.cadastro.repository;

import com.crud.cadastro.model.Cidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{
    
}
