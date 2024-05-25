package com.codeing.grupos.controller;

import com.codeing.grupos.entities.Grupo;
import com.codeing.grupos.services.IGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupo")
@CrossOrigin("*")
public class GrupoController {

    @Autowired
    private IGrupoService service;

    @GetMapping("/getAll")
    public List<Grupo> getAll(){
        return service.getAll();
    }

    @GetMapping("/getGrupo/{idGrupo}")
    public Grupo getGrupo(@PathVariable String idGrupo){
        return service.getGrupo(Long.parseLong(idGrupo));
    }
	
	@GetMapping("/getGruposCarrera/{idCarrera}")
    public List<Grupo> getGruposCarrera(@PathVariable String idCarrera){
        return service.getGruposCarrera(Long.parseLong(idCarrera));
    }

    /*@PostMapping("/saveGrupo")
    public void saveGrupo(@RequestBody Grupo grupo){
        service.save(grupo);
    }*/
}
