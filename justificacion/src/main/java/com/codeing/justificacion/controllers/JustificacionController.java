package com.codeing.justificacion.controllers;

import com.codeing.justificacion.dto.JustificacionRequestDTO;
import com.codeing.justificacion.dto.JustificacionSaveDTO;
import com.codeing.justificacion.entities.Asistencia;
import com.codeing.justificacion.entities.Justificacion;
import com.codeing.justificacion.services.IJustificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/justificacion")
@CrossOrigin("*")
public class JustificacionController {
    @Autowired
    private IJustificacionService service;

    @GetMapping("/getJustificacion/{idJustificacion}")
    public Justificacion getJustificacion(@PathVariable String idJustificacion){
        return service.getJustificacionById(idJustificacion);
    }

    @PostMapping("/getJustificacion")
    public Justificacion getJustificacionDirectivo(@RequestBody JustificacionRequestDTO a) {
        return service.getJustificacion(a.getIdJustificacion(), a.getIdDirectivo());
    }

    @GetMapping("/getAll/{idDirectivo}")
    public List<Justificacion> getAll(@PathVariable String idDirectivo){
        return service.getAll(idDirectivo);
    }

    @PostMapping("/updateJustificacion")
    public void updateJustificacion(@RequestBody Justificacion j){
        service.updateJustificacion(j);
    }

    @PostMapping("/saveJustificacion")
    public void saveJustificacion(@RequestBody JustificacionSaveDTO sJ){
        service.saveJustificacion(sJ.getJustificacion(), sJ.getAsistencia());
    }

}
