package com.codeing.grupos.repository;

import com.codeing.grupos.entities.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {
	
	Optional<List<Grupo>> findAllByIdCarrera(Long idCarrera);
	
}
