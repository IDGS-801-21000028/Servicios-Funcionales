package com.codeing.personal.services;

import com.codeing.personal.dto.AlumnoDTO;
import com.codeing.personal.entities.Alumno;

import java.util.List;

public interface IAlumnoService {

    List<AlumnoDTO> getAll();

    Alumno getAlumnoById(String id);

    List<AlumnoDTO> getAlumnosGrupo(String idGrupo);

    List<AlumnoDTO> findAlumnosByIdGrupoIn(List<Long> idsGrupo);
}
