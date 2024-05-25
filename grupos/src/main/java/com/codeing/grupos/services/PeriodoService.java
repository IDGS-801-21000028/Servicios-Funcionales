package com.codeing.grupos.services;

import com.codeing.grupos.cqrs.query.PeriodoQueryCQRS;
import com.codeing.grupos.entities.Periodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodoService implements IPeriodoService{

    @Autowired
    private PeriodoQueryCQRS periodoQueryCQRS;

    @Override
    public Periodo getPeriodo(Long idPeriodo) {
        return periodoQueryCQRS.getPeriodo(idPeriodo);
    }

    @Override
    public List<Periodo> getAll() {
        return periodoQueryCQRS.getAll();
    }
}
