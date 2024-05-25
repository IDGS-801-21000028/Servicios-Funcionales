package com.codeing.asistencias.dto;

import com.codeing.asistencias.entities.Justificacion;
import com.codeing.asistencias.entities.ListaAsistencia;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AsistenciaDTO {
    private Long idAsistencia;
    private Date fecha;
    private char asistencia;
    private int idAlumno;
    private int idHorario;
    private int idDocente;
    private Object justificacion;
    private Boolean justificado;
    private int idlista;
}
