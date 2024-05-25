package com.codeing.asistencias.repository;

import com.codeing.asistencias.entities.ListaAsistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface listaAsistenciaRepository extends JpaRepository<ListaAsistencia, Long> {

    List<ListaAsistencia> findAllByIdDocenteAndIdPeriodo(Long idDocente, Long idPeriodo);

    List<ListaAsistencia> findByIdDocenteAndFechaInicioGreaterThanEqualAndFechaFinLessThanEqual(
            Long idDocente, Date fechaInicio, Date fechaFin
    );

}

