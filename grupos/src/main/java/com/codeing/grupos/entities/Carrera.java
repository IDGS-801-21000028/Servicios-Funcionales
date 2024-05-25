package com.codeing.grupos.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "carrera")
@Getter @Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCarrera")
    private Long idCarrera;

    @Column(name = "nombre")
    private String nombre;
}
