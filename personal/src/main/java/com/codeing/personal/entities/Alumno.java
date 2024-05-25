package com.codeing.personal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "alumno")
@Getter @Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
public class Alumno {
    @Id
    @Column(name = "matricula")
    private String matricula;

    @Column(name = "idPersona", nullable = false)
    private Long idPersona;

    @Column(name = "idGrupo", nullable = false)
    private Long idGrupo;
}
