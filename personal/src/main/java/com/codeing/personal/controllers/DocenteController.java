package com.codeing.personal.controllers;


import com.codeing.personal.dto.DocenteDTO;
import com.codeing.personal.entities.Docente;
import com.codeing.personal.services.IDocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docente")
@CrossOrigin("*")
public class DocenteController {

    @Autowired
    private IDocenteService service;

    @GetMapping("/getAll")
    public List<DocenteDTO> getAll() {
        return  service.getAll();
    }

    @GetMapping("/getDocente/{idDocente}")
    public DocenteDTO getDocenteById(@PathVariable String idDocente){
        return service.getDocenteById(idDocente);
    }

    @GetMapping("/getDocenteByCarrera/{idCarrera}")
    public List<DocenteDTO> getDocenteByCarrera(@PathVariable String idCarrera){
        return service.getDocenteByCarrera(Long.parseLong(idCarrera));
    }
}
