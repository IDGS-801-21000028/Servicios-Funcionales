package com.codeing.grupos.controller;

import com.codeing.grupos.entities.Horario;
import com.codeing.grupos.entities.HorarioDetalle;
import com.codeing.grupos.services.IHorarioDetalleService;
import com.codeing.grupos.services.IHorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/horario")
@CrossOrigin("*")
public class HorarioController {

    @Autowired
    private IHorarioService service;

    @Autowired
    private IHorarioDetalleService serviceHorarioDetalle;

    @GetMapping("/getAll")
    public List<Horario> getAll(){
        return service.getAll();
    }

    @GetMapping("/getHorario/{idHorario}")
    public Horario getHorario(@PathVariable String idHorario){
        return service.getHorario(Long.parseLong(idHorario));
    }    

    @PostMapping("/save/{idLista}")
    public void saveAll(@RequestBody List<Horario> h, @PathVariable Long idLista) {
        service.saveAll(h, idLista);
    }

    @PostMapping("/saveHorarioDetalle")
    public void saveAllHorarioDetalle(List<HorarioDetalle> hde){
        serviceHorarioDetalle.saveAll(hde);
    }

}
