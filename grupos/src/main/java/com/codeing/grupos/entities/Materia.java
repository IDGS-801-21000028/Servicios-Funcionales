package com.codeing.grupos.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "materia")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idMateria")
    private Long idMateria;

    @Column(name="nombre")
    private String nombre;
	
	@Column(name="idCarrera")
    private Long idCarrera;

}
