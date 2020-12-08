package com.spring.rest.springrest.controllers;

import java.util.List;
import java.util.Optional;

import com.spring.rest.springrest.model.Usuario;
import com.spring.rest.springrest.service.UsuarioService;

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
@RequestMapping("/usuario")
public class UsuarioController {
    
    private UsuarioService usuarioService;

    @Autowired
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @GetMapping
    public List<Usuario> listAll () {
        return usuarioService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Usuario> getOne(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.findyById(id);
        if(usuario.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            Usuario record = usuario.get();
            return ResponseEntity.ok().body(record);
        }
    }


    @PostMapping
    public ResponseEntity<Usuario> insert(@RequestBody Usuario usuario) {

        usuarioService.saveAndFlush(usuario);

        return ResponseEntity.status(201).build();
        // return ResponseEntity.ok().body(usuario);
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.findyById(id).map( record -> {
            usuarioService.saveAndFlush(usuario);
            return ResponseEntity.ok().body(usuario);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        return usuarioService.findyById(id).map(record ->{
            usuarioService.delete(record.getId());
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
    

