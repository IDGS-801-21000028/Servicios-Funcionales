package com.codeing.grupos.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "grupo")
@Getter @Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idGrupo")
    private Long idGrupo;

    @Column(name="nombre")
    private String nombre;

    @Column(name="idCarrera")
    private Long idCarrera;

    @Column(name="generacion")
    private String generacion;

}
