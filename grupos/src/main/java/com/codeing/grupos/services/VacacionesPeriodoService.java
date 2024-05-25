package com.codeing.grupos.services;

import com.codeing.grupos.cqrs.query.VacacionesPeriodoQueryCQRS;
import com.codeing.grupos.entities.Vacacion;
import com.codeing.grupos.entities.VacacionesPeriodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VacacionesPeriodoService implements IVacacionesPeriodoService {

    @Autowired
    private VacacionesPeriodoQueryCQRS cqrs;

    @Autowired
    private IVacacionesService service;

    @Override
    public List<Vacacion> getVacacionPeriodo(Long idPeriodo) {
        
        List<VacacionesPeriodo> vacaciones = cqrs.getVacacionPeriodo(idPeriodo);

        List<Long> idsVacacion = new ArrayList<>();

        vacaciones.forEach(v -> {
            idsVacacion.add(v.getIdVacaciones());
        });

        return service.getVacaciones(idsVacacion);
    }

    /*@Override
    public void saveVacacionPeriodo(List<VacacionesPeriodo> vacacionesList) {
        cqrs.saveVacacionesPeriodo(vacacionesList);
    }*/
}
