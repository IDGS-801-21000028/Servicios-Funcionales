package com.codeing.grupos.services;

import com.codeing.grupos.cqrs.command.HorarioDetalleCommandCQRS;
import com.codeing.grupos.entities.HorarioDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioDetalleService implements IHorarioDetalleService{

    @Autowired
    private HorarioDetalleCommandCQRS cqrs;

    public void saveAll(List<HorarioDetalle> hda){
        cqrs.saveAll(hda);
    }
}
