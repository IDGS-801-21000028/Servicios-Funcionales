package com.codeing.justificacion.dto;

import com.codeing.justificacion.entities.Asistencia;
import com.codeing.justificacion.entities.Justificacion;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JustificacionSaveDTO {
    private Justificacion justificacion;
    private Asistencia asistencia;
}
