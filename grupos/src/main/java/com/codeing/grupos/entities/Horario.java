package com.codeing.grupos.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "horario")
@Getter
@Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idHorario")
    private Long idHorario;

    @Column(name="diaSemana")
    private String diaSemana;

    @Column(name="horaInicio")
    private String horaInicio;

    @Column(name="horaFin")
    private String horaFin;

    @Column(name="idMateria")
    private Long idMateria;

    @Column(name="idGrupo")
    private Long idGrupo;

    @Column(name="idPeriodo")
    private Long idPeriodo;


}
