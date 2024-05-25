package com.codeing.asistencias.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ListaAsistenciasDTO {
    private List<Long> longList;
    private Long idEntidad;
    private String fechaInicio;
    private String fechaFin;
}
