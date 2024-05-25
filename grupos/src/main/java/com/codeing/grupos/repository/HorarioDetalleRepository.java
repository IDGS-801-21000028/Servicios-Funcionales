package com.codeing.grupos.repository;

import com.codeing.grupos.entities.HorarioDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioDetalleRepository extends JpaRepository<HorarioDetalle, Long> {

}
