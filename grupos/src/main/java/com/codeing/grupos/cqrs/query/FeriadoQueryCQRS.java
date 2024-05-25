package com.codeing.grupos.cqrs.query;

import com.codeing.grupos.entities.Feriado;
import com.codeing.grupos.repository.FeriadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeriadoQueryCQRS {

    @Autowired
    private FeriadoRepository repository;

    public List<Feriado> getAll() {
        return repository.findAll();
    }

    public Feriado getFeriado(Long idFeriado){
        return repository.findById(idFeriado).orElseThrow(() -> {
            return new IllegalStateException("Error al obtener el registro con el ID: " + idFeriado);
        });
    }

    public List<Feriado> getFeriados(List<Long> listIds){
        return repository.findByIdFeriadoIn(listIds).orElseThrow(() -> {
            return new IllegalStateException("Erro al obtener el dato con el id: " + listIds);
        });
    }

}
