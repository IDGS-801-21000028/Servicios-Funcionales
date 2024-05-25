package com.codeing.personal.services;

import com.codeing.personal.cqrs.AlumnoQueryCQRS;
import com.codeing.personal.dto.AlumnoDTO;
import com.codeing.personal.entities.Alumno;
import com.codeing.personal.entities.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnoService implements IAlumnoService {

    @Autowired
    private AlumnoQueryCQRS alumnoQueryCQRS;

    @Autowired
    private PersonaService personaService;

    @Override
    public List<AlumnoDTO> getAll(){

        List<Alumno> alumnos = alumnoQueryCQRS.getAll();

        return getAlumnoDTOS(alumnos);
    }

    @Override //Get one Alumno
    public Alumno getAlumnoById(String id){
        return alumnoQueryCQRS.getAlumnoById(id);
    }

    @Override //Alumnos by Grupo
    public List<AlumnoDTO> getAlumnosGrupo(String idGrupo){

        List<Alumno> alumnos = alumnoQueryCQRS.getAlumnosGrupo(idGrupo);

        return getAlumnoDTOS(alumnos);
    }

    @Override // Alumnos by carrera
    public List<AlumnoDTO> findAlumnosByIdGrupoIn(List<Long> idsGrupo){

        List<Alumno> alumnos = alumnoQueryCQRS.findAlumnosByIdGrupoIn(idsGrupo);

        return getAlumnoDTOS(alumnos);
    }

    private List<AlumnoDTO> getAlumnoDTOS(List<Alumno> alumnos) {
        List<AlumnoDTO> alumnosList = new ArrayList<>();

        alumnos.forEach(a -> {

            AlumnoDTO alumnoDTO = new AlumnoDTO();

            Persona p = personaService.getPersona(a.getIdPersona());

            alumnoDTO.setMatricula(a.getMatricula());
            alumnoDTO.setIdGrupo(a.getIdGrupo());
            alumnoDTO.setPersona(p);

            alumnosList.add(alumnoDTO);

        });

        return alumnosList;
    }
}
