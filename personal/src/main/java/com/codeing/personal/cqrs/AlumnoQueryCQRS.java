package com.codeing.personal.cqrs;

import com.codeing.personal.entities.Alumno;
import com.codeing.personal.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlumnoQueryCQRS {

    @Autowired
    private AlumnoRepository alumnoRepository;

    //Get All Alumno
    public List<Alumno> getAll(){
        return alumnoRepository.findAll();
    }

    //Get One Alumno
    public Alumno getAlumnoById(String id){
        return alumnoRepository
                .findById(id)
                .orElseThrow(() ->{
                    return new IllegalStateException("No existe el registro con ID (Alumno): " + id);
                });
    }

    //Get Alumnos by Grupo
    public List<Alumno> getAlumnosGrupo(String idGrupo){
        return alumnoRepository
                .getAlumnosGrupo(idGrupo)
                .orElseThrow(() ->{
                    return new IllegalStateException("No existe el grupo con el id: " + idGrupo);
                });

    }

    //Get Alumnos by Carrera
    public List<Alumno> findAlumnosByIdGrupoIn(List<Long> idGrupos){
        return alumnoRepository
                .findAlumnosByIdGrupoIn(idGrupos)
                .orElseThrow(() ->{
                    return new IllegalStateException("Error al obtener los datos");
                });
    }

}
