package com.codeing.justificacion.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "asistencia")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAsistencia")
    private Long idAsistencia;

    @Column(name = "fecha", nullable = false, unique = true)
    private Date fecha;

    @Column(name = "asistencia", nullable = false, unique = true)
    private char asistencia;

    @Column(name = "idAlumno", nullable = false, unique = true)
    private int idAlumno;

    @Column(name = "idHorario", nullable = false, unique = true)
    private int idHorario;

    @Column(name = "idDocente", nullable = false, unique = true)
    private int idDocente;

    @Column(name = "idJustificacion", nullable = false, unique = true)
    private int idJustificacion;

    @Column(name = "justificado", nullable = false, unique = true)
    private Boolean justificado;

    @Column(name = "idLista", nullable = false, unique = true)
    private int idLista;
}
