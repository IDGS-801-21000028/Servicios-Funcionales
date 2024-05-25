package com.codeing.asistencias.services;

import com.codeing.asistencias.dto.AsistenciaDTO;
import com.codeing.asistencias.entities.Asistencia;

import java.util.List;

public interface IAsistenciaService {
    Object getAsistencia(int idAlumno, int idHorario, int idDocente);

    List<AsistenciaDTO> getAsistenciaClase(int idHorario, int idDocente);

    List<AsistenciaDTO> getListaAsistencias(List<Long> alumnosId, Long idHorario, String inicio, String fin);

    void saveAsistencia(Asistencia a);

    void saveAsistencias(List<Asistencia> la);

    Asistencia getAsistenciaJ(String idJustificacion);
}
