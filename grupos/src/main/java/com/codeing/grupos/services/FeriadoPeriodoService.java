package com.codeing.grupos.services;

import com.codeing.grupos.cqrs.command.FeriadoPeriodoCommandCQRS;
import com.codeing.grupos.cqrs.query.FeriadoPeriodoQueryCQRS;
import com.codeing.grupos.entities.Feriado;
import com.codeing.grupos.entities.FeriadoPeriodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeriadoPeriodoService implements IFeriadoPeriodoService {

    @Autowired
    private FeriadoPeriodoCommandCQRS cqrsCmd;

    @Autowired
    private FeriadoPeriodoQueryCQRS cqrsQuery;

    @Autowired
    private IFeriadoService Fservice;

    @Override
    public List<Feriado> getFeriadosPeriodo(Long idPeriodo) {

        List<FeriadoPeriodo> datos = cqrsQuery.getFeriadosPeriodo(idPeriodo);

        List<Long> idsFeriado = new ArrayList<>();

        datos.forEach(d -> {
            idsFeriado.add(d.getIdFeriado());
        });

        return Fservice.getFeriados(idsFeriado);    
    }

    @Override
    public void saveFeriadoPeriodo(List<FeriadoPeriodo> feriadoLista) {
        cqrsCmd.saveFeriadoPeriodo(feriadoLista);
    }
}
