package com.codeing.grupos.controller;

import com.codeing.grupos.entities.Parcial;
import com.codeing.grupos.services.IParcialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parcial")
@CrossOrigin("*")
public class ParcialController {

    @Autowired
    private IParcialService service;

    @GetMapping("/getAll")
    public List<Parcial> getAll(){
        return service.getAll();
    }

    @GetMapping("/getParcial/{idPeriodo}")
    public List<Parcial> getParcial(@PathVariable String idPeriodo){
        return service.getParcial(Long.parseLong(idPeriodo));
    }    
}
