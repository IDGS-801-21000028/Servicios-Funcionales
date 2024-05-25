package com.codeing.grupos.services;

import com.codeing.grupos.cqrs.query.GrupoQueryCQRS;
import com.codeing.grupos.entities.Grupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoService implements IGrupoService {

    @Autowired
    private GrupoQueryCQRS grupoQueryCQRS;

    @Override
    public Grupo getGrupo(Long idGrupo) {
        return grupoQueryCQRS.getGrupo(idGrupo);
    }

    @Override
    public List<Grupo> getAll() {
        return grupoQueryCQRS.getAll();
    }
	
	@Override
	public List<Grupo> getGruposCarrera(Long idCarrera){
		return grupoQueryCQRS.getGruposCarrera(idCarrera);
	}

}
