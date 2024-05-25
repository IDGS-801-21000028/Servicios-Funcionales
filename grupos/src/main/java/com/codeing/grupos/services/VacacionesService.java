package com.codeing.grupos.services;

import com.codeing.grupos.cqrs.query.VacacionQueryCQRS;
import com.codeing.grupos.entities.Vacacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacacionesService implements IVacacionesService {

    @Autowired
    private VacacionQueryCQRS vacacionQueryCQRS;

    @Override
    public List<Vacacion> getAll() {
        return vacacionQueryCQRS.getAll();
    }

    @Override
    public Vacacion getVacacion(Long idVacacion) {
        return vacacionQueryCQRS.getVacacion(idVacacion);
    }

    @Override
    public List<Vacacion> getVacaciones(List<Long> idsVacacion) {
        return vacacionQueryCQRS.getVacaciones(idsVacacion);
    }    
}
