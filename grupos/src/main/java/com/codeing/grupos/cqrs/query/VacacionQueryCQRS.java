package com.codeing.grupos.cqrs.query;

import com.codeing.grupos.entities.Vacacion;
import com.codeing.grupos.repository.VacacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VacacionQueryCQRS {

    @Autowired
    private VacacionRepository repository;

    public List<Vacacion> getAll(){
        return repository.findAll();
    }

    public Vacacion getVacacion(Long idVacacion){
        return repository.findById(idVacacion).orElseThrow(() -> {
            return new IllegalStateException("Error al obtener el registro con el ID: " + idVacacion);
        });
    }

    public List<Vacacion> getVacaciones(List<Long> idsVacacion){
        return repository.findByIdVacacionIn(idsVacacion).orElseThrow(() -> {
            return new IllegalStateException("Error al obtener el registro con el ID: " + idsVacacion);
        });
    }


    

}
