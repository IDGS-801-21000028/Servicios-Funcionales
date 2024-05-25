package com.codeing.asistencias.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AsistenciaEventDTO {
    private Long idAsistencia;
    private int idAlumno;
    private int idHorario;
    private int idDocente;
    private int idJustificacion;
    private int idLista;
}
