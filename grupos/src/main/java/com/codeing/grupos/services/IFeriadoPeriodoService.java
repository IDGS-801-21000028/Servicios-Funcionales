package com.codeing.grupos.services;

import com.codeing.grupos.entities.Feriado;
import com.codeing.grupos.entities.FeriadoPeriodo;

import java.util.List;

public interface IFeriadoPeriodoService {

    List<Feriado> getFeriadosPeriodo(Long idPeriodo);

    void saveFeriadoPeriodo(List<FeriadoPeriodo> feriadoLista);

}
