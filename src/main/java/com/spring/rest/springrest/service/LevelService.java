package com.spring.rest.springrest.service;

import java.util.List;
import java.util.Optional;

import com.spring.rest.springrest.model.Level;
import com.spring.rest.springrest.repository.LevelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
public class LevelService {

    private LevelRepository repository;

    @Autowired
    public void setRepository(LevelRepository repository) {
        this.repository = repository;
    }
    public List<Level> findAll () {
        return repository.findAll();
    }

    public Level save(Level level){
      return repository.save(level);
    }
    public Level saveAndFlush(Level level){
     return repository.saveAndFlush(level);
    }

    public Level getById(Long id) {
        return repository.getOne(id);
    }
    
    public void delete(Long id){
        repository.deleteById(id);
    }
    
    public Optional <Level> findyById(Long id) {
        return repository.findById(id);
    }
}
    

