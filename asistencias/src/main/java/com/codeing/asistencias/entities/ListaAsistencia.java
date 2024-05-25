package com.codeing.asistencias.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "lista_Asistencia")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ListaAsistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLista")
    private Long idLista;

    @Column(name = "idMateria", nullable = false, unique = true)
    private Long idMateria;

    @Column(name = "idDocente", nullable = false, unique = true)
    private Long idDocente;

    @Column(name = "idGrupo", nullable = false, unique = true)
    private Long idGrupo;

    @Column(name = "idPeriodo", nullable = false, unique = true)
    private Long idPeriodo;

    @Column(name = "fechaInicio", nullable = false, unique = true)
    private Date fechaInicio;

    @Column(name = "fechaFin", nullable = false, unique = true)
    private Date fechaFin;
}
