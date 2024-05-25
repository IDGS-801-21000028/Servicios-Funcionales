package com.codeing.grupos.services;

import com.codeing.grupos.cqrs.query.HorarioQueryCQRS;
import com.codeing.grupos.entities.Horario;
import com.codeing.grupos.entities.HorarioDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HorarioService implements IHorarioService{

    @Autowired
    private HorarioQueryCQRS horarioQueryCQRS;

    @Autowired
    private IHorarioDetalleService hdService;

    @Override
    public List<Horario> getAll() {
        return horarioQueryCQRS.getAll();
    }

    @Override    
    public Horario getHorario(Long idHorario) {
        return horarioQueryCQRS.getHorario(idHorario);
    }
    
    @Override
    public void saveAll(List<Horario> h, Long idLista){

        List<Horario> listaHorarios = horarioQueryCQRS.saveAll(h);

        System.out.println(listaHorarios);

        List<HorarioDetalle> horarioDetalle = new ArrayList<>();

        listaHorarios.forEach(lista -> {
           HorarioDetalle hd = new HorarioDetalle();
           hd.setIdHorario(lista.getIdHorario());
           hd.setIdLista(idLista);
           horarioDetalle.add(hd);
        });

        hdService.saveAll(horarioDetalle);
    }
}
