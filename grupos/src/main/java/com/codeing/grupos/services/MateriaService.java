package com.codeing.grupos.services;

import com.codeing.grupos.cqrs.query.MateriaQueryCQRS;
import com.codeing.grupos.entities.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaService implements IMateriaService{

    @Autowired
    private MateriaQueryCQRS materiaQueryCQRS;

    @Override
    public Materia getMateria(Long idMateria) {
        return materiaQueryCQRS.getMateria(idMateria);
    }

    @Override
    public List<Materia> getAll() {
        return materiaQueryCQRS.getAll();
    }
	
	@Override
	public List<Materia> getMateriaCarrera(Long idCarrera){
		return materiaQueryCQRS.getMateriaCarrera(idCarrera);
	}
}
