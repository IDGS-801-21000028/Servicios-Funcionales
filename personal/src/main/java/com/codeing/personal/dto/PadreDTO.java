package com.codeing.personal.dto;

import com.codeing.personal.entities.Persona;
import lombok.*;

@Getter @Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
public class PadreDTO {
    private Long idPadre;
    private Persona persona;
}
