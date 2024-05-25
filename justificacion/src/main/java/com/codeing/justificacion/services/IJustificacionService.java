package com.codeing.justificacion.services;

import com.codeing.justificacion.entities.Asistencia;
import com.codeing.justificacion.entities.Justificacion;

import java.util.List;

public interface IJustificacionService {

    //Justificacion por Directivo
    Justificacion getJustificacion(int idJustificacion, int idDirectivo);

    Justificacion getJustificacionById(String idJustificacion);

    List<Justificacion> getAll(String idDirectivo);

    void updateJustificacion(Justificacion j);

    void saveJustificacion(Justificacion j, Asistencia a);



}
