package com.codeing.asistencias.dto;

import com.codeing.asistencias.entities.ListaAsistencia;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ListaAsistenciaRequestDTO {
    private ListaAsistencia listaAsistencia;
    private List<Object> obj;
}
