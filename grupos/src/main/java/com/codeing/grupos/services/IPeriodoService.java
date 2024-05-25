package com.codeing.grupos.services;

import com.codeing.grupos.entities.Periodo;

import java.util.List;

public interface IPeriodoService {

    Periodo getPeriodo(Long idPeriodo);

    List<Periodo> getAll();

}
