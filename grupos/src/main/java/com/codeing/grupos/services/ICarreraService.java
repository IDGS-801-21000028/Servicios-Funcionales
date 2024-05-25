package com.codeing.grupos.services;

import com.codeing.grupos.entities.Carrera;

import java.util.List;

public interface ICarreraService {

    Carrera getCarreraById(Long id);

    List<Carrera> getAll();

}
