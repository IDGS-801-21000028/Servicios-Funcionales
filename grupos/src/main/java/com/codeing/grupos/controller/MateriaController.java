package com.codeing.grupos.controller;

import com.codeing.grupos.entities.Materia;
import com.codeing.grupos.services.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materia")
@CrossOrigin("*")
public class MateriaController {

    @Autowired
    private IMateriaService service;

    @GetMapping("/getAll")
    public List<Materia> getAll(){
        return service.getAll();
    }

    @GetMapping("/getMateria/{idMateria}")
    public Materia getMateria(@PathVariable String idMateria){
        return service.getMateria(Long.parseLong(idMateria));
    }   

	@GetMapping("/getMateriaCarrera/{idCarrera}")
    public List<Materia> getMateriaCarrera(@PathVariable String idCarrera){
        return service.getMateriaCarrera(Long.parseLong(idCarrera));
    }  	

}
