package com.codeing.asistencias.cqrs;

import com.codeing.asistencias.dto.ListaAsistenciasDTO;
import com.codeing.asistencias.entities.ListaAsistencia;
import com.codeing.asistencias.repository.listaAsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ListaAsistenciaQueryCQRS {

    @Autowired
    private listaAsistenciaRepository repository;

    public List<ListaAsistencia> getListaAsistencia(Long idDocente, Long idPeriodo){
        return repository.findAllByIdDocenteAndIdPeriodo(idDocente, idPeriodo);
    }

}
