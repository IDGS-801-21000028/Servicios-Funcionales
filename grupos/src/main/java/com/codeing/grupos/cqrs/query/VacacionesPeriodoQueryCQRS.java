package com.codeing.grupos.cqrs.query;

import com.codeing.grupos.entities.Vacacion;
import com.codeing.grupos.entities.VacacionesPeriodo;
import com.codeing.grupos.repository.VacacionesPeriodoRepository;
import com.codeing.grupos.services.IVacacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VacacionesPeriodoQueryCQRS {

    @Autowired
    private VacacionesPeriodoRepository repository;

    public List<VacacionesPeriodo> getVacacionPeriodo(Long idPeriodo){
       return repository.findAllByIdPeriodo(idPeriodo).orElseThrow(() -> {
           return new IllegalArgumentException("Error al obtener datos de id " + idPeriodo);
       });
    }

}
