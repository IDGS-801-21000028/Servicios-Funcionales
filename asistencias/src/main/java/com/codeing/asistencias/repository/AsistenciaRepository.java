package com.codeing.asistencias.repository;

import com.codeing.asistencias.entities.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {

    @Query("SELECT a FROM Asistencia a WHERE a.idAlumno = :idAlumno AND a.idHorario = :idHorario AND a.idDocente = :idDocente")
    Optional<Asistencia> getAsistencia(
            @Param("idAlumno") int idAlumno,
            @Param("idHorario") int idHorario,
            @Param("idDocente") int idDocente
    );

    @Query("SELECT a FROM Asistencia a WHERE a.idHorario = :idHorario AND a.idDocente = :idDocente")
    Optional<List<Asistencia>> getAsistenciaClase(
            @Param("idHorario") int idHorario,
            @Param("idDocente") int idDocente
    );

    Optional<List<Asistencia>> findByIdAlumnoInAndIdHorarioAndFechaBetween(
      List<Long> alumnosId, Long idHorario, Date inicio, Date fin
    );

    Optional<Asistencia> findAsistenciaByIdJustificacion(Long idJustificacion);




}
