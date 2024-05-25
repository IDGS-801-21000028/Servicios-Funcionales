package com.codeing.asistencias.controllers;

import com.codeing.asistencias.dto.AsistenciaDTO;
import com.codeing.asistencias.dto.AsistenciaRequestDTO;
import com.codeing.asistencias.dto.ListaAsistenciasDTO;
import com.codeing.asistencias.entities.Asistencia;
import com.codeing.asistencias.services.IAsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/asistencia")
@CrossOrigin
public class AsistenciaController {

    @Autowired
    private IAsistenciaService service;

    @PostMapping("/getAsistencia/alumno")
    public ResponseEntity<Object> getAsistencias(@RequestBody AsistenciaRequestDTO a) {

        Object res = service.getAsistencia(a.getIdAlumno(), a.getIdHorario(), a.getIdDocente());

        return ResponseEntity.ok(res);
    }

    @GetMapping("/getAsistenciaClase")
    public List<AsistenciaDTO> getAsistenciaClase(@RequestBody AsistenciaRequestDTO a) {
        return service.getAsistenciaClase(a.getIdHorario(), a.getIdDocente());
    }

    @PostMapping("/saveAsistencia")
    public ResponseEntity<Object> saveAsistencia(@RequestBody Asistencia a) {
         service.saveAsistencia(a);

         return ResponseEntity.ok(new Object());
    }

    @PostMapping("/saveAsistencias/lista")
    public void saveAsistencias(@RequestBody List<Asistencia> la) {
         service.saveAsistencias(la);
    }

    @PostMapping("/getAsistenciasGrupo")
    public List<AsistenciaDTO> getListaAsistencias(@RequestBody ListaAsistenciasDTO a){
        return service.getListaAsistencias(a.getLongList(), a.getIdEntidad(), a.getFechaInicio(), a.getFechaFin());
    }

    @PostMapping("/getAsistenciasJustificacion/{idJustificacion}")
    public Asistencia getAsistencia(@PathVariable String idJustificacion){
        return service.getAsistenciaJ(idJustificacion);
    }

}
