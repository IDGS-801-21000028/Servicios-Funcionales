package com.codeing.personal.repository;

import com.codeing.personal.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, String> {

    //Alumnos Por grupo
    @Query("SELECT a FROM Alumno a WHERE a.idGrupo = :idGrupo")
    Optional<List<Alumno>> getAlumnosGrupo(@Param("idGrupo") String idGrupo);

    //Alumnos Por Carrera
    Optional<List<Alumno>> findAlumnosByIdGrupoIn(List<Long> idGrupos);

}
