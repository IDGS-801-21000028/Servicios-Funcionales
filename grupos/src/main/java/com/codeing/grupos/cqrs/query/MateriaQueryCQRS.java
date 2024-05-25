package com.codeing.grupos.cqrs.query;

import com.codeing.grupos.entities.Materia;
import com.codeing.grupos.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MateriaQueryCQRS {

    @Autowired
    private MateriaRepository repository;

    public Materia getMateria(Long idMateria){
        return repository.findById(idMateria).orElseThrow(() -> {
            return new IllegalStateException("Error al obtener el registro con el ID: " + idMateria);
        });
    }

    public List<Materia> getAll(){
        return repository.findAll();
    }
	
	public List<Materia> getMateriaCarrera(Long idCarrera){
        return repository.findAllByIdCarrera(idCarrera).orElseThrow(() -> {
            return new IllegalStateException("Error al obtener el registro con el ID: " + idCarrera);
        });
    }
	
	

}
