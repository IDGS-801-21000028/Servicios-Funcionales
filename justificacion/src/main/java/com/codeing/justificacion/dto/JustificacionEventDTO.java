package com.codeing.justificacion.dto;
import lombok.*;
@Getter @Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
public class JustificacionEventDTO {
    private int idJustificacion;
    private Object idDirectivo;
    private String descripcion;
}
