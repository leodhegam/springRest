package com.spring.rest.springrest.repository;

import com.spring.rest.springrest.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    
}
