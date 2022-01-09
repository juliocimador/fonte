package com.crud.cadastro.repository;

import com.crud.cadastro.model.UnidadeFederativa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UfRepository extends JpaRepository<UnidadeFederativa,Long>{
    
}
