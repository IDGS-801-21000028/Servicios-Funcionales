package com.codeing.autenticacion.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario")
@Getter @Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUsuario")
    private Long id;

    @Column(name = "usuario", nullable = false, unique = true)
    private String user;

    @Column(name = "contrasenia", nullable = false)
    private String password;

    @Column(name = "idRol", nullable = false)
    private Long rol;
}