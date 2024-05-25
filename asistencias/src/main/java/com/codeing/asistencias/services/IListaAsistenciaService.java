package com.codeing.asistencias.services;

import com.codeing.asistencias.dto.ListaAsistenciaRequestDTO;
import com.codeing.asistencias.dto.ListaAsistenciasDTO;
import com.codeing.asistencias.entities.ListaAsistencia;

import java.util.List;

public interface IListaAsistenciaService {

    List<ListaAsistencia> getListaAsistencias(Long idDocente, Long idPeriodo);

    void save(ListaAsistenciaRequestDTO la);

}
