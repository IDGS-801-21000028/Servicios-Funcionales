package com.codeing.grupos.controller;

import com.codeing.grupos.entities.FeriadoPeriodo;
import com.codeing.grupos.entities.Vacacion;
import com.codeing.grupos.entities.VacacionesPeriodo;
import com.codeing.grupos.services.IVacacionesPeriodoService;
import com.codeing.grupos.services.IVacacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacacion")
@CrossOrigin("*")
public class VacacionesController {

    @Autowired
    private IVacacionesService service;

    @Autowired
    private IVacacionesPeriodoService servicePeriodo;

    @GetMapping("/getAll")
    public List<Vacacion> getAll(){
        return service.getAll();
    }

    @GetMapping("/getVacacion/{idVacacion}")
    public Vacacion getVacacion(@PathVariable String idVacacion){
        return service.getVacacion(Long.parseLong(idVacacion));
    }    

    @GetMapping("/getVacacionPeriodo/{idPeriodo}")
    public List<Vacacion> getAllVacaciones(@PathVariable String idPeriodo) {
        return servicePeriodo.getVacacionPeriodo(Long.parseLong(idPeriodo));
    }

    /*@PostMapping("/saveVacaciones")
    public void saveVacaciones(List<VacacionesPeriodo> listaVacaciones){
        servicePeriodo.saveVacacionesPeriodo(listaVacaciones);
    }}*/
    
}