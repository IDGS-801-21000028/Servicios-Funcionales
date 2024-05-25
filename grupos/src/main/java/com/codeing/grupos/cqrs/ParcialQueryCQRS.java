package com.codeing.grupos.cqrs;

import com.codeing.grupos.entities.Parcial;
import com.codeing.grupos.repository.ParcialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParcialQueryCQRS {

    @Autowired
    private ParcialRepository repository;

    public List<Parcial> getParcial(Long idPeriodo){
        return repository.findAllByIdPeriodo(idPeriodo).orElseThrow(() -> {
            return new IllegalStateException("Error al obtener el registro con el ID: " + idPeriodo);
        });
    }

    public List<Parcial> getAll(){
        return repository.findAll();
    }


}
