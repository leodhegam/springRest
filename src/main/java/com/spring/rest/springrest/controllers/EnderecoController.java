package com.spring.rest.springrest.controllers;

import java.util.List;
import java.util.Optional;

import com.spring.rest.springrest.model.Endereco;
import com.spring.rest.springrest.service.EnderecoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private EnderecoService enderecoService;

    @Autowired
    public void setEnderecoService(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }


    @GetMapping
    public List<Endereco> listAll () {
        return enderecoService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Endereco> getOne(@PathVariable Long id) {
        Optional<Endereco> endereco = enderecoService.findyById(id);
        if(endereco.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            Endereco record = endereco.get();
            return ResponseEntity.ok().body(record);
        }
    }


    @PostMapping
    public ResponseEntity<Endereco> insert(@RequestBody Endereco endereco) {

        enderecoService.saveAndFlush(endereco);

        return ResponseEntity.status(201).build();
        // return ResponseEntity.ok().body(endereco);
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<Endereco> update(@PathVariable Long id, @RequestBody Endereco endereco) {
        return enderecoService.findyById(id).map( record -> {
            enderecoService.saveAndFlush(endereco);
            return ResponseEntity.ok().body(endereco);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        return enderecoService.findyById(id).map(record ->{
            enderecoService.delete(record.getId());
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}

