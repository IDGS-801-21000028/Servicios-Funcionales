package com.codeing.grupos.services;

import com.codeing.grupos.entities.Horario;

import java.util.List;

public interface IHorarioService {

    Horario getHorario(Long idHorario);

    List<Horario> getAll();

    void saveAll(List<Horario> h, Long idLista);
}
