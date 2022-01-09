package com.crud.cadastro.repository;

import com.crud.cadastro.model.Nacionalidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NacionalidadeRepository extends JpaRepository<Nacionalidade,Long>{
    
}
