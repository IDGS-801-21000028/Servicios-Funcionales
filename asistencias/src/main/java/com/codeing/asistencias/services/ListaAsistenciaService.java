package com.codeing.asistencias.services;

import com.codeing.asistencias.cqrs.ListaAsistenciaComandCQRS;
import com.codeing.asistencias.cqrs.ListaAsistenciaQueryCQRS;
import com.codeing.asistencias.dto.ListaAsistenciaRequestDTO;
import com.codeing.asistencias.dto.ListaAsistenciasDTO;
import com.codeing.asistencias.entities.ListaAsistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaAsistenciaService implements IListaAsistenciaService{

    @Autowired
    private ListaAsistenciaQueryCQRS queryCQRS;
    @Autowired
    private ListaAsistenciaComandCQRS comandCQRS;
    @Autowired
    private ServiceClient client;

    @Override
    public List<ListaAsistencia> getListaAsistencias(Long idDocente, Long idPeriodo) {
        return queryCQRS.getListaAsistencia(idDocente, idPeriodo);
    }

    @Override
    public void save(ListaAsistenciaRequestDTO la) {
        ListaAsistencia lista = comandCQRS.saveListaAsistencia(la.getListaAsistencia());
        Long idLista = lista.getIdLista();
        client.urlBase = "http://localhost:8083/";
        client.callPostService("api/horario/save/",la.getObj(),Object.class);

    }
}
