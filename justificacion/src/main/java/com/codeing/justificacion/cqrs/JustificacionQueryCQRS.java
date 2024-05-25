package com.codeing.justificacion.cqrs;

import com.codeing.justificacion.entities.Justificacion;
import com.codeing.justificacion.repository.JustificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JustificacionQueryCQRS {
    @Autowired
    private JustificacionRepository repository;

    public Justificacion getJustificacion(int idJustificacion, int idDirectivo) {
        return repository
                .getJustificacionByIdJustificacionAndIdDirectivo(idJustificacion, idDirectivo)
                .orElseThrow(() -> {
                    return new IllegalArgumentException("Error de datos");
                });
    }

    public Justificacion getJustificacionById(String idJustificacion){
        return repository.findById(Long.parseLong(idJustificacion)).orElseThrow(() -> {
            return new IllegalArgumentException("Error de datos");
        });
    }

    public List<Justificacion> getAll(String idDirectivo){
        return repository.findAllByIdDirectivo(Long.parseLong(idDirectivo));
    }

    public Justificacion saveJustificacion(Justificacion j){
        return repository.save(j);
    }

    public void updateJustificacion(Justificacion j){
        repository.save(j);
    }

}
