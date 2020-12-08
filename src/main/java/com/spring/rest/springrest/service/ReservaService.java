package com.spring.rest.springrest.service;

import java.util.List;
import java.util.Optional;


import com.spring.rest.springrest.model.Reserva;
import com.spring.rest.springrest.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

     private ReservaRepository repository;

    @Autowired
    public void setRepository(ReservaRepository repository) {
        this.repository = repository;
    }
    public List<Reserva> findAll() {
        return repository.findAll();
    }

    public Reserva save(Reserva reserva){
      return repository.save(reserva);
    }
    public Reserva saveAndFlush(Reserva reserva){
     return repository.saveAndFlush(reserva);
    }

    public Reserva getById(Long id) {
        return repository.getOne(id);
    }
    
    public void delete(Long id){
        repository.deleteById(id);
    }
    public Optional <Reserva> findyById(Long id) {
        return repository.findById(id);
    }


    

}
