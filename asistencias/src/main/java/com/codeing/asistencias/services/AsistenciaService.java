package com.codeing.asistencias.services;


import com.codeing.asistencias.cqrs.AsistenciaQueryCQRS;
import com.codeing.asistencias.cqrs.AsistenciasComandCQRS;
import com.codeing.asistencias.dto.AsistenciaDTO;
import com.codeing.asistencias.dto.AsistenciaEventDTO;
import com.codeing.asistencias.dto.AsistenciaRequestDTO;
import com.codeing.asistencias.entities.Asistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AsistenciaService implements IAsistenciaService {

    @Autowired
    private AsistenciaQueryCQRS queryCQRS;

    @Autowired
    private AsistenciasComandCQRS comandCQRS;

    @Autowired
    private ServiceClient client;

    @Override
    public Object getAsistencia(int idAlumno, int idHorario, int idDocente) {

        Asistencia a = queryCQRS.getAsistencia(idAlumno, idHorario, idDocente);
        Object asistencia;

        if (a.getJustificado()) {
            asistencia = getJustificacion(a, true);
        } else {
            asistencia = a;
        }

        return asistencia;
    }

    @Override
    public List<AsistenciaDTO> getAsistenciaClase(int idHorario, int idDocente) {

        List<Asistencia> rest = queryCQRS.getAsistenciaClase(idHorario,idDocente);

        List<AsistenciaDTO> listAsistencia = new ArrayList<>();

        rest.forEach(a -> {
            AsistenciaDTO aF = new AsistenciaDTO(a.getIdAsistencia(), a.getFecha(), a.getAsistencia(), a.getIdAlumno(), a.getIdHorario(), a.getIdDocente(), a.getIdJustificacion(), a.getJustificado(), a.getIdLista());
            listAsistencia.add(aF);
        });

        return listAsistencia;
    }

    @Override
    public List<AsistenciaDTO> getListaAsistencias(List<Long> alumnosId, Long idHorario, String inicio, String fin) {

        List<Asistencia> a = queryCQRS.getListaAsistencias(alumnosId, idHorario, inicio, fin);

        List<AsistenciaDTO> liAsistencia = new ArrayList<>();

        a.forEach(asistencia -> {
            if (asistencia.getJustificado()) {
                liAsistencia.add(getJustificacion(asistencia, true));
            } else {
                liAsistencia.add(getJustificacion(asistencia, false));
            }
        });

        return liAsistencia;
    }

    @Override
    public void saveAsistencia(Asistencia a) {
        comandCQRS.saveAsistencia(a);
    }

    @Override
    public void saveAsistencias(List<Asistencia> la) {
        comandCQRS.saveAsistencias(la);
    }

    @Override
    public Asistencia getAsistenciaJ(String idJustificacion) {
        return queryCQRS.getAsistenciaByIdJus(idJustificacion);
    }

    public AsistenciaDTO getJustificacion(Asistencia a, Boolean justificacion){


        AsistenciaDTO aDTO = new AsistenciaDTO();

        if (justificacion){
            client.urlBase = "http://localhost:8084";

            Object response = client.callGetService("/api/justificacion/getJustificacion/" + a.getIdJustificacion() , Object.class);

            aDTO.setJustificacion(response);
        } else {
            aDTO.setJustificacion(null);
        }

        aDTO.setIdAsistencia(a.getIdAsistencia());
        aDTO.setFecha(a.getFecha());
        aDTO.setAsistencia(a.getAsistencia());
        aDTO.setIdAlumno(a.getIdAlumno());
        aDTO.setIdHorario(a.getIdHorario());
        aDTO.setIdDocente(a.getIdDocente());

        aDTO.setJustificado(a.getJustificado());
        aDTO.setIdlista(a.getIdLista());

        return aDTO;
    }
}
