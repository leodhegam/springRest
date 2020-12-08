package com.spring.rest.springrest.controllers;

import java.util.List;
import java.util.Optional;

import com.spring.rest.springrest.model.Reserva;

import com.spring.rest.springrest.service.ReservaService;

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
@RequestMapping("/reserva")
public class ReservaController {

    private ReservaService reservaService;

    @Autowired
    public void setReservaService(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public List<Reserva> listAll() {
        return reservaService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Reserva> getOne(@PathVariable Long id) {
        Optional<Reserva> reserva = reservaService.findyById(id);
        if(reserva.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            Reserva record = reserva.get();
            return ResponseEntity.ok().body(record);
        }
    }


    @PostMapping
    public ResponseEntity<Reserva> insert(@RequestBody Reserva reserva) {

        reservaService.saveAndFlush(reserva);

        return ResponseEntity.status(201).build();
        // return ResponseEntity.ok().body(reserva);
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<Reserva> update(@PathVariable Long id, @RequestBody Reserva reserva) {
        return reservaService.findyById(id).map( record -> {
            reservaService.saveAndFlush(reserva);
            return ResponseEntity.ok().body(reserva);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        return reservaService.findyById(id).map(record ->{
            reservaService.delete(record.getId());
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
    

