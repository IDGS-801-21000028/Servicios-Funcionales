package com.codeing.personal.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "escolares")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Escolares {
    @Id
    @Column(name = "matricula")
    private String matricula;

    @Column(name = "idPersona", nullable = false)
    private Long idPersona;
}
