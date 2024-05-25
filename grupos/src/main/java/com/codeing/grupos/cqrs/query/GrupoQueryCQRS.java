package com.codeing.grupos.cqrs.query;

import com.codeing.grupos.entities.Grupo;
import com.codeing.grupos.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GrupoQueryCQRS {

    @Autowired
    private GrupoRepository repository;

    public Grupo getGrupo(Long idGrupo){
        return repository.findById(idGrupo).orElseThrow(() -> {
            return new IllegalStateException("Error al obtener el registro con el id: " + idGrupo);
        });
    }

    public List<Grupo> getAll(){
        return repository.findAll();
    }
	
	public List<Grupo> getGruposCarrera(Long idCarrera){
		return repository.findAllByIdCarrera(idCarrera).orElseThrow(() -> {
            return new IllegalStateException("Error al obtener el registro con el id: " + idCarrera);
        });
	}

}
