package com.codeing.grupos.cqrs;

import com.codeing.grupos.entities.Carrera;
import com.codeing.grupos.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarreraQueryCQRS {

    @Autowired
    private CarreraRepository repository;

    public Carrera getCarreraById(Long id){
        return repository
                .findById(id)
                .orElseThrow(() -> {
                    return new IllegalStateException("Error al obtener la carrera con el id: " + id);
                });
    }

    public List<Carrera> getAll(){
        return repository.findAll();
    }

}
