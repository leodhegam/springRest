package com.spring.rest.springrest.service;

import java.util.List;
import java.util.Optional;

import com.spring.rest.springrest.model.Piscina;
import com.spring.rest.springrest.repository.PiscinaRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PiscinaService {

     private PiscinaRepository repository;

    @Autowired
    public void setRepository(PiscinaRepository repository) {
        this.repository = repository;
    }
    public List<Piscina> findAll() {
        return repository.findAll();
    }

    public Piscina save(Piscina piscina){
      return repository.save(piscina);
    }
    public Piscina saveAndFlush(Piscina piscina){
     return repository.saveAndFlush(piscina);
    }

    public Piscina getById(Long id) {
        return repository.getOne(id);
    }
    
    public void delete(Long id){
        repository.deleteById(id);
    }
    public Optional <Piscina> findyById(Long id) {
        return repository.findById(id);
    }


    

}
