package com.codeing.justificacion.entities;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "justificacion")
@Getter @Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
public class Justificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idJustificacion")
    private int idJustificacion;

    @Column(name = "idDirectivo", nullable = false)
    private int idDirectivo;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

}




