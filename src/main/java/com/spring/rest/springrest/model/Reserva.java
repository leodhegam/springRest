package com.spring.rest.springrest.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @DateTimeFormat(pattern = "dd/MM/yyyy")@NotBlank(message = ApiPosts.DATE_ERROR)
    Date entrada;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date saida;
    @Size(min = 1,max = 10) @NotBlank(message = ApiPosts.PEOPLE_NUMBER)
    Integer qtdPessoas;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    Usuario usuario;

    @ManyToOne
    @JoinColumn(name="piscina_id")
    Piscina piscina;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "reserva_piscina",
        joinColumns = @JoinColumn(name="reserva_id",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="piscina_id")
        )
        List<Piscina> piscinas;

}
