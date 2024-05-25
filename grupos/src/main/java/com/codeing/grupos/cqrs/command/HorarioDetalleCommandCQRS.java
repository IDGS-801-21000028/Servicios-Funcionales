package com.codeing.grupos.cqrs.command;

import com.codeing.grupos.entities.HorarioDetalle;
import com.codeing.grupos.repository.HorarioDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HorarioDetalleCommandCQRS {

    @Autowired
    private HorarioDetalleRepository repository;

    public void saveAll(List<HorarioDetalle> hde){
        repository.saveAll(hde);
    }
}
