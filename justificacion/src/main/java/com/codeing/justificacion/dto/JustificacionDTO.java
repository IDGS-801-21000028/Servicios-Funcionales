package com.codeing.justificacion.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter @Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
public class JustificacionDTO {
    private int idJustificacion;
    private Object idDirectivo;
    private String descripcion;

}
