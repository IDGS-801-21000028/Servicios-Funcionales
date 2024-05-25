package com.codeing.personal.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "docente")
@Getter @Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
public class  Docente {
    @Id
    @Column(name = "matricula")
    private String matricula;

    @Column(name = "idPersona", nullable = false)
    private Long idPersona;

    @Column(name = "idCarrera", nullable = false)
    private Long idCarrera;
}
