package com.spring.rest.springrest.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import javax.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Size(min = 3,max = 60) @NotBlank(message = ApiPosts.R_ERROR)
    String rua;
    @Size(min = 3,max = 60) @NotBlank(message = ApiPosts.CITY_ERROR)
    String cidade;
    
    // @Size(min = 8,max = 8) @NotBlank(message = ApiPosts.CEP_ERROR)
    String cep;

    
    @OneToOne(mappedBy = "endereco", cascade = CascadeType.PERSIST)
    Usuario usuario;
}