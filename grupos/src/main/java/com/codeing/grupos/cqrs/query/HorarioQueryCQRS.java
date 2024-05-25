package com.codeing.grupos.cqrs.query;

import com.codeing.grupos.entities.Horario;
import com.codeing.grupos.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HorarioQueryCQRS {

    @Autowired
    private HorarioRepository repository;

    public Horario getHorario(Long idHorario){
        return repository.findById(idHorario).orElseThrow(() -> {
            return new IllegalStateException("Error al obtener los datos id: " + idHorario);
        });
    }

    public List<Horario> getAll(){
        return repository.findAll();
    }

    public List<Horario> saveAll(List<Horario> h){
       return repository.saveAll(h);
    }

}
