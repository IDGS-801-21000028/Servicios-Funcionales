package com.codeing.grupos.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "periodo")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Periodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPeriodo")
    private Long idPeriodo;

    @Column(name="nombrePeriodo")
    private String nombre;

    @Column(name="fechaInicio")
    private String fechaInicio;

    @Column(name="fechaFin")
    private String fechaFin;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="rangoPeriodo")
    private String rango;

    @Column(name="anio")
    private String anio;



}
