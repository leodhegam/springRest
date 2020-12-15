package com.spring.rest.springrest.service;

import java.util.List;
import java.util.Optional;

import com.spring.rest.springrest.model.Usuario;
import com.spring.rest.springrest.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UsuarioService {

     private UsuarioRepository repository;

    @Autowired
    public void setRepository(UsuarioRepository repository) {
        this.repository = repository;
    }
    public List<Usuario> findAll () {
        return repository.findAll();
    }

    public Usuario save(Usuario usuario){
      return repository.save(usuario);
    }
    public Usuario saveAndFlush(Usuario usuario){
     return repository.saveAndFlush(usuario);
    }

    public Usuario getById(Long id) {
        return repository.getOne(id);
    }
    
    public void delete(Long id){
        repository.deleteById(id);
    }
    public Optional <Usuario> findyById(Long id) {
        return repository.findById(id);
    }


    

}
