package com.codeing.personal.cqrs;

import com.codeing.personal.entities.Persona;
import com.codeing.personal.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonaQueryCQRS {

    @Autowired
    private PersonaRepository personaRepository;

    public Persona getPersona(Long id){
        return personaRepository.findById(id).orElseThrow(() ->{
            return new IllegalStateException("No existe el registro con ID (Persona): " + id);
        });
    }

}
