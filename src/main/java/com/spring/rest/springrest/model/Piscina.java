package com.spring.rest.springrest.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Piscina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Size(min = 3,max = 60) @NotBlank(message = ApiPosts.TAM_ERROR)
    String nome;
    @Size(min = 5,max = 60) @NotBlank(message = ApiPosts.TAM_ERROR)
    String tipo;
    @Size(min = 3,max = 6) @NotBlank(message = ApiPosts.TAM_ERROR_PISCINA)
    String tamanho;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , orphanRemoval = true , mappedBy = "piscina")
    List<Reserva> reserva;

}
