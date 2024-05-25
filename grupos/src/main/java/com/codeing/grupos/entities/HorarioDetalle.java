package com.codeing.grupos.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "horarioDetalle")
@Getter @Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
public class HorarioDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idHorarioDetalle")
    private Long idHorarioDetalle;

    @Column(name="idHorario")
    private Long idHorario;

    @Column(name="idLista")
    private Long idLista;
}
