package com.codeing.grupos.repository;

import com.codeing.grupos.entities.Parcial;
import com.codeing.grupos.entities.Vacacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VacacionRepository extends JpaRepository<Vacacion, Long> {   

    Optional<List<Vacacion>> findByIdVacacionIn(List<Long> idVacaciones);

}
