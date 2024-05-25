package com.codeing.grupos.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "feriado_periodo")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FeriadoPeriodo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idFeriadoPeriodo")
    private Long id;

    @Column(name="idPeriodo")
    private Long idPeriodo;

    @Column(name="idFeriado")
    private Long idFeriado;
}
