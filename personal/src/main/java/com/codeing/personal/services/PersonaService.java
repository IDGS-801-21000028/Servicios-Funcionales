package com.codeing.personal.services;

import com.codeing.personal.cqrs.PersonaQueryCQRS;
import com.codeing.personal.entities.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    private PersonaQueryCQRS personaQueryCQRS;

    @Override
    public Persona getPersona(Long id){
        return personaQueryCQRS.getPersona(id);
    }

}
