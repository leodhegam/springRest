package com.spring.rest.springrest.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nome;
    // @NotBlank(message = ApiPosts.DATE_ERROR)
    String entrada;
    // @Size(min=3 , max = 30)@NotBlank(message = ApiPosts.TAM_ERROR)
   
    // @NotBlank(message = ApiPosts.DATE_ERROR)
    String saida;
    // @Size(min = 1,max = 10) @NotBlank(message = ApiPosts.PEOPLE_NUMBER)
    String qtdPessoas;

    @ManyToOne(cascade = CascadeType.MERGE )
    @JoinColumn(name="usuario_id")
    Usuario usuario;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="piscina_id")
    Piscina piscina;
    
    // @ManyToMany(cascade = CascadeType.ALL)
    // @JoinTable(
    //     name = "reserva_piscina",
    //     joinColumns = @JoinColumn(name="reserva_id",referencedColumnName = "id"),
    //     inverseJoinColumns = @JoinColumn(name="piscina_id")
    //     )
    //     List<Piscina> piscinas;
}
