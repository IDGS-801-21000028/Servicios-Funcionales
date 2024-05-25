package com.codeing.grupos.services;

import com.codeing.grupos.entities.Vacacion;

import java.util.List;

public interface IVacacionesService  {

    List<Vacacion> getAll();

    Vacacion getVacacion(Long idVacacion);

    List<Vacacion>  getVacaciones(List<Long> idsVacacion);
    
}
