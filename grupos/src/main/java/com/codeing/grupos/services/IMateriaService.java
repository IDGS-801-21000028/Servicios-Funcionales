package com.codeing.grupos.services;

import com.codeing.grupos.entities.Materia;

import java.util.List;

public interface IMateriaService {

    Materia getMateria(Long idMateria);

    List<Materia> getAll();
	
	List<Materia> getMateriaCarrera(Long idCarrera);

}
