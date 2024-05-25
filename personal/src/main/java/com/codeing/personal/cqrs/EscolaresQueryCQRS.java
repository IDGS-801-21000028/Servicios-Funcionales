package com.codeing.personal.cqrs;


import com.codeing.personal.entities.Escolares;
import com.codeing.personal.repository.EscolaresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EscolaresQueryCQRS {

    @Autowired
    private EscolaresRepository escolaresRepository;

    public Escolares getEscolares(String id) {
        return escolaresRepository.findById(id).orElseThrow(() ->{
            return new IllegalStateException("No existe el registro con ID (Escolares): " + id);
        });
    }
}
