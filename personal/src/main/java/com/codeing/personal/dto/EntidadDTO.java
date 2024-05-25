package com.codeing.personal.dto;

import com.codeing.personal.entities.Persona;
import lombok.*;

@Getter @Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
public class EntidadDTO {
    private String matricula;
    private Persona persona;
}
