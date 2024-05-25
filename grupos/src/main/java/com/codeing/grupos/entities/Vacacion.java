package com.codeing.grupos.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "vacaciones")
@Getter
@Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
public class Vacacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVacaciones")
    private Long idVacacion;

    @Column(name = "fechaInicio")
    private String fechaInicio;

    @Column(name = "fechaFin")
    private String fechaFin;

    @Column(name = "motivo")
    private String motivo;
}
