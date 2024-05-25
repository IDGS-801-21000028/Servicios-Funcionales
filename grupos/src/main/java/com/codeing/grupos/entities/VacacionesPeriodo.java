package com.codeing.grupos.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "vacacionesPeriodo")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class VacacionesPeriodo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idVacacionesPeriodo")
    private Long idVacacionesPeriodo;

    @Column(name="idPeriodo")
    private Long idPeriodo;

    @Column(name="idVacaciones")
    private Long idVacaciones;
}

