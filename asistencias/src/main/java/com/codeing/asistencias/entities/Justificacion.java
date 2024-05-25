package com.codeing.asistencias.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "justificacion")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Justificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idJustificacion")
    private Long idJustificacion;

    @Column(name = "idDirectivo", nullable = false, unique = true)
    private Long idDirectivo;

    @Column(name = "descripcion", nullable = false, unique = true)
    private String descripcion;
}
