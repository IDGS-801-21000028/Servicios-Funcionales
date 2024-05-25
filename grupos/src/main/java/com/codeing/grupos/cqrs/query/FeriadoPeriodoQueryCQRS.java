package com.codeing.grupos.cqrs.query;

import com.codeing.grupos.entities.FeriadoPeriodo;
import com.codeing.grupos.repository.FeriadoPeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeriadoPeriodoQueryCQRS {
    
    @Autowired
    private FeriadoPeriodoRepository repository;

    public List<FeriadoPeriodo> getFeriadosPeriodo(Long idPeriodo){
        return repository.findAllByIdPeriodo(idPeriodo).orElseThrow(() -> {
            return new IllegalArgumentException("Error al obtener datos de id " + idPeriodo);
        });
    }


}
