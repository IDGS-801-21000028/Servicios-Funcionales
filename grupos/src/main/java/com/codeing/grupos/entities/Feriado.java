package com.codeing.grupos.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "feriado")
@Getter @Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
public class Feriado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idFeriado")
    private Long idFeriado;

    @Column(name="nombreFeriado")
    private String nombre;

    @Column(name="fechaFeriado")
    private String fecha;

}
