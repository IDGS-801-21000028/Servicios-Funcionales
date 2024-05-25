package com.codeing.grupos.services;

import com.codeing.grupos.entities.Grupo;

import java.util.List;

public interface IGrupoService {

    Grupo getGrupo(Long idGrupo);

    List<Grupo> getAll();
	
	List<Grupo> getGruposCarrera(Long idCarrera);
}
