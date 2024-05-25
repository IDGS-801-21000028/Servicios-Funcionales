package com.codeing.personal.repository;

import com.codeing.personal.entities.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, String> {

    Optional<List<Docente>> findDocenteByIdCarrera(Long carrera);
}
