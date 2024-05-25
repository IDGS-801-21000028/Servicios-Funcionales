package com.codeing.grupos.services;

import com.codeing.grupos.cqrs.CarreraQueryCQRS;
import com.codeing.grupos.entities.Carrera;
import com.codeing.grupos.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraService implements ICarreraService {

    @Autowired
    private CarreraQueryCQRS carreraQueryCQRS;

    @Override
    public Carrera getCarreraById(Long id) {
        return carreraQueryCQRS.getCarreraById(id);
    }

    @Override
    public List<Carrera> getAll() {
        return carreraQueryCQRS.getAll();
    }
}
