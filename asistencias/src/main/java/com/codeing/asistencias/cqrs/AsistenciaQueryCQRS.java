package com.codeing.asistencias.cqrs;

import com.codeing.asistencias.dto.AsistenciaDTO;
import com.codeing.asistencias.dto.AsistenciaRequestDTO;
import com.codeing.asistencias.entities.Asistencia;
import com.codeing.asistencias.repository.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Component
public class AsistenciaQueryCQRS {

    @Autowired
    private AsistenciaRepository repository;

    public Asistencia getAsistencia(int idAlumno, int idHorario, int idDocente) {
        return repository
                .getAsistencia(idAlumno, idHorario,idDocente)
                .orElseThrow(() -> {
                    return new IllegalArgumentException("Error de datos");
                });
    }

    public List<Asistencia> getAsistenciaClase(int idHorario, int idDocente) {
        return repository
                .getAsistenciaClase(idHorario, idDocente)
                .orElseThrow(() -> {
                    return new IllegalArgumentException("Error de datos");
                });
    }

    public List<Asistencia> getListaAsistencias(List<Long> alumnosId, Long idHorario, String inicio, String fin){
        return repository
                .findByIdAlumnoInAndIdHorarioAndFechaBetween(
                alumnosId, idHorario, new Date(inicio), new Date(fin)).orElseThrow(() -> {
                    return new IllegalArgumentException("Error de datos");
                });
    }

    public Asistencia getAsistenciaByIdJus(String idJustificacion){
        return repository.findAsistenciaByIdJustificacion(Long.parseLong(idJustificacion)).orElseThrow(() -> {
            return new IllegalArgumentException("Error de datos");
        });
    }

}