package com.codeing.personal.dto;

import com.codeing.personal.entities.Persona;
import lombok.*;

@Getter @Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
public class DocenteDTO {
    private String matricula;
    private Persona persona;
    private Object carrera;
}
