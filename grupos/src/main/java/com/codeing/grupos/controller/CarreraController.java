package com.codeing.grupos.controller;

import com.codeing.grupos.entities.Carrera;
import com.codeing.grupos.services.ICarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrera")
@CrossOrigin("*")
public class CarreraController {

    @Autowired
    private ICarreraService service;

    @GetMapping("/getAll")
    public List<Carrera> getAll(){
        return service.getAll();
    }

    @GetMapping("/getCarrera/{id}")
    public Carrera getCarreraById(@PathVariable String id) {
        return service.getCarreraById(Long.parseLong(id));
    }    
}
