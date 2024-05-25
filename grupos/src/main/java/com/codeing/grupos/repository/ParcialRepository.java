package com.codeing.grupos.repository;

import com.codeing.grupos.entities.Parcial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParcialRepository extends JpaRepository<Parcial, Long> {

    Optional<List<Parcial>> findAllByIdPeriodo(Long idPeriodo);
}
