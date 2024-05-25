package com.codeing.personal.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "padre")
@Getter @Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
public class Padre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPadre")
    private Long idPadre;

    @Column(name = "idPersona", nullable = false)
    private Long idPersona;

    @Column(name = "idUsuario", nullable = false)
    private Long idUsuario;
}
