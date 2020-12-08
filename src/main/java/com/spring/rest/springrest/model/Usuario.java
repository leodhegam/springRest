package com.spring.rest.springrest.model;

import java.util.List;

import javax.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
   
    @Size(min = 3,max = 60) @NotBlank(message = ApiPosts.TAM_ERROR)
    String nome;
   
    @Email @NotBlank(message = ApiPosts.EMAIL_ERROR)
    String email;

    @Size(min = 8 , max = 20) @NotBlank(message = ApiPosts.PASSWORD_ERROR)
    String senha;
    
    Boolean flag;

    @OneToOne(cascade = {CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name="endereco_id")
    Endereco endereco;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true , mappedBy = "usuario")
    List<Reserva> reserva;
    
}
