package com.codeing.personal.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "persona")
@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersona")
    private Long idPersona;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "primerApellido", nullable = false)
    private String primerApellido;

    @Column(name = "segundoApellido", nullable = false)
    private String segundoApellido;
}
