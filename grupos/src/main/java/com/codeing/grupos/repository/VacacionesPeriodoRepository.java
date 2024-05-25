package com.codeing.grupos.repository;

import com.codeing.grupos.entities.Vacacion;
import com.codeing.grupos.entities.VacacionesPeriodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VacacionesPeriodoRepository extends JpaRepository<VacacionesPeriodo, Long> {

    Optional<List<VacacionesPeriodo>> findAllByIdPeriodo(Long idPeriodo);

}
