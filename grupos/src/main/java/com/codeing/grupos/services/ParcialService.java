package com.codeing.grupos.services;

import com.codeing.grupos.cqrs.ParcialQueryCQRS;
import com.codeing.grupos.entities.Parcial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcialService implements IParcialService{

    @Autowired
    private ParcialQueryCQRS parcialQueryCQRS;

    @Override
    public List<Parcial> getParcial(Long idPeriodo) {
        return parcialQueryCQRS.getParcial(idPeriodo);
    }

    @Override
    public List<Parcial> getAll() {
        return parcialQueryCQRS.getAll();
    }
}
