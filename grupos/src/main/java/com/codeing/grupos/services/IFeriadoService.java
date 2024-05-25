package com.codeing.grupos.services;

import com.codeing.grupos.entities.Feriado;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IFeriadoService {

    List<Feriado> getAll();

    Feriado getFeriado(Long idFeriado);

    List<Feriado> getFeriados(List<Long> idFeriado);
}
