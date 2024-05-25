package com.codeing.grupos.controller;

import com.codeing.grupos.entities.Periodo;
import com.codeing.grupos.services.IPeriodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/periodo")
@CrossOrigin("*")
public class PeriodoController  {

    @Autowired
    private IPeriodoService service;

    @GetMapping("/getAll")
    public List<Periodo> getAll(){
        return service.getAll();
    }

    @GetMapping("/getPeriodo/{idPeriodo}")
    public Periodo getPeriodo(@PathVariable String idPeriodo){
        return service.getPeriodo(Long.parseLong(idPeriodo));
    }  
}
