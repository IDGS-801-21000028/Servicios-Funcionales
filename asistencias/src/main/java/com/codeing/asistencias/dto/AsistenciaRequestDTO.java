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
public class AsistenciaRequestDTO {
    private int idAlumno;
    private int idHorario;
    private int idDocente;
    private int idLista;
}
