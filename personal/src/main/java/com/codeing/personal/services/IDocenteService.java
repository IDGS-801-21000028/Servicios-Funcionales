package com.codeing.personal.services;

import com.codeing.personal.dto.DocenteDTO;
import com.codeing.personal.entities.Docente;

import java.util.List;

public interface IDocenteService {

    List<DocenteDTO> getAll();

    DocenteDTO getDocenteById(String id);

    List<DocenteDTO> getDocenteByCarrera(Long carrera);
}
