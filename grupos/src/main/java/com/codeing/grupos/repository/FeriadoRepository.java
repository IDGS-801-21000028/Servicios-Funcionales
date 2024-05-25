package com.codeing.grupos.repository;

import com.codeing.grupos.entities.Feriado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeriadoRepository extends JpaRepository<Feriado, Long> {

    Optional<List<Feriado>> findByIdFeriadoIn(List<Long> idFeriado);

}
