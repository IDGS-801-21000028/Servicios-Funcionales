package com.codeing.personal.cqrs;

import com.codeing.personal.entities.Docente;
import com.codeing.personal.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DocenteQueryCQRS {

    @Autowired
    private DocenteRepository docenteRepository;

    public List<Docente> getAll(){
        return docenteRepository.findAll();
    }

    public Docente getDocenteById(String id){
        return docenteRepository.findById(id).orElseThrow(() ->{
            return new IllegalStateException("No existe el registro con ID (Docente): " + id);
        });
    }

    public List<Docente> getDocenteByCarrea(Long carrera){
        return docenteRepository
                .findDocenteByIdCarrera(carrera)
                .orElseThrow(() -> {
                    return new IllegalStateException("No existen registros con la carrera " + carrera);
                });
    }
}
