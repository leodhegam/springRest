package com.spring.rest.springrest.controllers;

import java.util.List;
import java.util.Optional;

import com.spring.rest.springrest.model.Piscina;

import com.spring.rest.springrest.service.PiscinaService;

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
@RequestMapping("/piscina")
public class PiscinaController {
    
    private PiscinaService piscinaService;

    @Autowired
    public void setPiscinaService(PiscinaService piscinaService) {
        this.piscinaService = piscinaService;
    }
    @GetMapping
    public List<Piscina> listAll () {
        return piscinaService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Piscina> getOne(@PathVariable Long id) {
        Optional<Piscina> piscina = piscinaService.findyById(id);
        if(piscina.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            Piscina record = piscina.get();
            return ResponseEntity.ok().body(record);
        }
    }


    @PostMapping
    public Piscina insert(@RequestBody Piscina piscina) {

       return  piscinaService.saveAndFlush(piscina);

        // return ResponseEntity.status(201).build();
        // return ResponseEntity.ok().body(piscina);
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<Piscina> update(@PathVariable Long id, @RequestBody Piscina piscina) {
        return piscinaService.findyById(id).map( record -> {
            piscinaService.saveAndFlush(piscina);
            return ResponseEntity.ok().body(piscina);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        return piscinaService.findyById(id).map(record ->{
            piscinaService.delete(record.getId());
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
    

