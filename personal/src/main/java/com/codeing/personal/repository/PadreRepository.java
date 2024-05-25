package com.codeing.personal.repository;

import com.codeing.personal.entities.Padre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PadreRepository  extends JpaRepository<Padre, Long> {
    @Query("SELECT p FROM Padre p WHERE p.idUsuario = :idUsuario")
    Optional<Padre> getPadre(@Param("idUsuario") Long idUsuario);
}
