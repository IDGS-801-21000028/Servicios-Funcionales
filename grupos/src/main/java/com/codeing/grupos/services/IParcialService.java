package com.codeing.grupos.services;

import com.codeing.grupos.entities.Parcial;

import java.util.List;

public interface IParcialService {

    List<Parcial> getParcial(Long idPeriodo);

    List<Parcial> getAll();

}
