package com.codeing.grupos.cqrs.command;

import com.codeing.grupos.entities.FeriadoPeriodo;
import com.codeing.grupos.repository.FeriadoPeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeriadoPeriodoCommandCQRS {

    @Autowired
    private FeriadoPeriodoRepository repository;

    public void saveFeriadoPeriodo(List<FeriadoPeriodo> feriadoLista){
        repository.saveAll(feriadoLista);
    }

}
