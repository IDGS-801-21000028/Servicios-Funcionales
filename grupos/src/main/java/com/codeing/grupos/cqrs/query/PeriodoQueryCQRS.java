package com.codeing.grupos.cqrs.query;

import com.codeing.grupos.entities.Periodo;
import com.codeing.grupos.repository.PeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PeriodoQueryCQRS {

    @Autowired
    private PeriodoRepository repository;

    public List<Periodo> getAll(){
        return repository.findAll();
    }

    public Periodo getPeriodo(Long idPeriodo){
        return repository.findById(idPeriodo).orElseThrow(() -> {
            return new IllegalStateException("Error al obtener el registro con el ID: " + idPeriodo);
        });
    }    

}
