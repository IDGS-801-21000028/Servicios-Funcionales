package com.codeing.grupos.controller;

import com.codeing.grupos.entities.Feriado;
import com.codeing.grupos.entities.FeriadoPeriodo;
import com.codeing.grupos.services.IFeriadoPeriodoService;
import com.codeing.grupos.services.IFeriadoService;

import com.codeing.grupos.dto.FeriadoPeriodoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feriado")
@CrossOrigin("*")
public class FeriadoController {

    @Autowired
    private IFeriadoService service;

    @Autowired
    private IFeriadoPeriodoService serviceFeriado;

    @GetMapping("/getAll")
    public List<Feriado> getAll(){
        return service.getAll();
    }

    @GetMapping("/getFeriado/{idFeriado}")
    public Feriado getFeriado(@PathVariable String idFeriado){
        return service.getFeriado(Long.parseLong(idFeriado));
    }

    @GetMapping("/getFeriadoPeriodo/{idPeriodo}")
    public List<Feriado> getAllFeriados(@PathVariable String idPeriodo){
        return serviceFeriado.getFeriadosPeriodo(Long.parseLong(idPeriodo));
    }

    @PostMapping("/saveFeriados")
    public void saveFeriados(List<FeriadoPeriodo> listaFeriados){
        serviceFeriado.saveFeriadoPeriodo(listaFeriados);
    }
}
