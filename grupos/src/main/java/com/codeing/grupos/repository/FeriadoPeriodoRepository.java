package com.codeing.grupos.repository;

import com.codeing.grupos.entities.FeriadoPeriodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeriadoPeriodoRepository extends JpaRepository<FeriadoPeriodo, Long> {

    Optional<List<FeriadoPeriodo>> findAllByIdPeriodo(Long idPeriodo);

}
