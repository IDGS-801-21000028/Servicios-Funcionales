package com.codeing.grupos.services;

import com.codeing.grupos.cqrs.query.FeriadoQueryCQRS;
import com.codeing.grupos.entities.Feriado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeriadoService implements IFeriadoService {

    @Autowired
    private FeriadoQueryCQRS feriadoQueryCQRS;

    @Override
    public List<Feriado> getAll(){
        return feriadoQueryCQRS.getAll();
    }

    @Override
    public Feriado getFeriado(Long idFeriado){
        return feriadoQueryCQRS.getFeriado(idFeriado);
    }

    @Override
    public List<Feriado> getFeriados(List<Long> idFeriados) {
        return feriadoQueryCQRS.getFeriados(idFeriados);
    }
}
