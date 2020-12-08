package com.spring.rest.springrest.repository;

import com.spring.rest.springrest.model.Reserva;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva,Long> {
    
}
