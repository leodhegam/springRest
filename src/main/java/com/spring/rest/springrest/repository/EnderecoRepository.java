package com.spring.rest.springrest.repository;

import com.spring.rest.springrest.model.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
    
}
