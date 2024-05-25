package com.codeing.grupos.repository;

import com.codeing.grupos.entities.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {
	Optional<List<Materia>> findAllByIdCarrera(Long idCarrera);
}