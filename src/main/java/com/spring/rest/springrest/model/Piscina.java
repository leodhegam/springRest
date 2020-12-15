package com.spring.rest.springrest.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    @Size(min = 3,max = 60) @NotBlank(message = ApiPosts.TAM_ERROR)
    String tipo;
    @NotBlank(message = ApiPosts.TAM_ERROR_PISCINA)
    String tamanho;

    @ManyToMany()
    @JoinTable(
    name = "piscina_level",
    joinColumns = @JoinColumn(name = "piscina_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "level_id")
    )
    List<Level> levels;

}
