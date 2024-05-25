package com.codeing.asistencias.controllers;

import com.codeing.asistencias.dto.ListaAsistenciaRequestDTO;
import com.codeing.asistencias.dto.ListaAsistenciasDTO;
import com.codeing.asistencias.entities.ListaAsistencia;
import com.codeing.asistencias.services.IListaAsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/listaAsistencia")
@CrossOrigin("*")
public class ListaAsistenciaController {

    @Autowired
    private IListaAsistenciaService service;

    @GetMapping("/getListaAsistencias/{idDocente}/{idPeriodo}")
    public List<ListaAsistencia> getListaAsistencia(@PathVariable Long idDocente, @PathVariable Long idPeriodo){
        return service.getListaAsistencias(idDocente, idPeriodo);
    }

    @PostMapping("/saveListaAsistenia")
    public ResponseEntity save(@RequestBody ListaAsistenciaRequestDTO la){
        System.out.println(la);
        service.save(la);
        return ResponseEntity.ok("recibido");
    }

}
