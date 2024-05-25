package com.codeing.justificacion.services;

import com.codeing.justificacion.cqrs.JustificacionQueryCQRS;
import com.codeing.justificacion.dto.JustificacionDTO;
import com.codeing.justificacion.entities.Asistencia;
import com.codeing.justificacion.entities.Justificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JustificacionService implements IJustificacionService{

    @Autowired
    private JustificacionQueryCQRS justificacionQueryCQRS;

    @Autowired
    private ServiceClient client;

    @Override
    public Justificacion getJustificacion(int idJustificacion, int idDirectivo) {
        return justificacionQueryCQRS.getJustificacion(idJustificacion, idDirectivo);
    }

    @Override
    public Justificacion getJustificacionById(String idJustificacion) {
        return justificacionQueryCQRS.getJustificacionById(idJustificacion);
    }

    @Override
    public List<Justificacion> getAll(String idDirectivo) {
        return justificacionQueryCQRS.getAll(idDirectivo);
    }

    @Override
    public void updateJustificacion(Justificacion j) {
        justificacionQueryCQRS.updateJustificacion(j);
    }

    @Override
    public void saveJustificacion(Justificacion j, Asistencia a) {

        Justificacion jG = justificacionQueryCQRS.saveJustificacion(j);

        client.urlBase = "http://localhost:8085";

        System.out.println(jG);

        a.setJustificado(true);
        a.setIdJustificacion(jG.getIdJustificacion());

        System.out.println(a);

        Object response = client.callPostService("/api/asistencia/saveAsistencia", a , Object.class);


    }


}
