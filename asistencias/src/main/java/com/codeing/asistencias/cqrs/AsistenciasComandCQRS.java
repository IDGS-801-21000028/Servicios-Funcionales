package com.codeing.asistencias.cqrs;

import com.codeing.asistencias.entities.Asistencia;
import com.codeing.asistencias.repository.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AsistenciasComandCQRS {

    @Autowired
    private AsistenciaRepository repository;

    public void saveAsistencia(Asistencia a){
        repository.save(a);
    }

    public void saveAsistencias(List<Asistencia> la){
        repository.saveAll(la);
    }

}
