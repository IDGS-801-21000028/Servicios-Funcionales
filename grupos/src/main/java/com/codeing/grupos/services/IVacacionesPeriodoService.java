package com.codeing.grupos.services;

import com.codeing.grupos.entities.Vacacion;
import com.codeing.grupos.entities.VacacionesPeriodo;

import java.util.List;

public interface IVacacionesPeriodoService {

    List<Vacacion> getVacacionPeriodo(Long idPeriodo);

    //void saveVacacionPeriodo(List<VacacionesPeriodo> vacacionesList);
}
