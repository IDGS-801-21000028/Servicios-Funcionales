package com.codeing.justificacion.repository;

import com.codeing.justificacion.entities.Justificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JustificacionRepository extends JpaRepository<Justificacion, Long> {

    /*@Query("SELECT a FROM Justificacion a WHERE a.idJustificacion = :idJustificacion AND a.idDirectivo = :idDirectivo")
    Optional<Justificacion> getJustificacion(
            @Param("idJustificacion") int idJustificacion,
            @Param("idDirectivo") int idDirectivo
    );*/

    Optional<Justificacion> getJustificacionByIdJustificacionAndIdDirectivo(int idJustificacion, int idDirectivo);

    List<Justificacion> findAllByIdDirectivo(Long idDirectivo);


}
