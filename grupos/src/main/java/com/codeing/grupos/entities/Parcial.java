package com.codeing.grupos.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "parciales")
@Getter @Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
public class Parcial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idParcial")
    private Long idParcial;

    @Column(name="fechaInicio")
    private String fechaInicio;

    @Column(name="fechaFin")
    private String fechaFin;

    @Column(name="numeroParcial")
    private String numParcial;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="idPeriodo")
    private Long idPeriodo;


}
