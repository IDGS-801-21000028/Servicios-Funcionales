package com.codeing.asistencias.cqrs;

import com.codeing.asistencias.entities.ListaAsistencia;
import com.codeing.asistencias.repository.listaAsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListaAsistenciaComandCQRS {

    @Autowired
    private listaAsistenciaRepository repository;

    public ListaAsistencia saveListaAsistencia(ListaAsistencia la){
         return repository.save(la);
    }
}
