package com.spring.rest.springrest.controllers;

import java.util.List;
import java.util.Optional;

import com.spring.rest.springrest.model.Level;
import com.spring.rest.springrest.service.LevelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
@RequestMapping("/level")

public class LevelController {

    private LevelService levelService;

    @Autowired
    public void setEnderecoService(LevelService levelService) {
        this.levelService = levelService;
    }


    @GetMapping
    public List<Level> listAll () {
        return levelService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Level> getOne(@PathVariable Long id) {
        Optional<Level> level = levelService.findyById(id);
        if(level.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            Level record = level.get();
            return ResponseEntity.ok().body(record);
        }
    }


    @PostMapping
    public Level insert(@RequestBody Level level) {

        return levelService.saveAndFlush(level);

        // return ResponseEntity.status(201).build();
        // return ResponseEntity.ok().body(level);
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<Level> update(@PathVariable Long id, @RequestBody Level level) {
        return levelService.findyById(id).map( record -> {
            levelService.saveAndFlush(level);
            return ResponseEntity.ok().body(level);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        return levelService.findyById(id).map(record ->{
            levelService.delete(record.getId());
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}

