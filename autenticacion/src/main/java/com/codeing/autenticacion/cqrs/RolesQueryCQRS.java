package com.codeing.autenticacion.cqrs;

import com.codeing.autenticacion.entities.Roles;
import com.codeing.autenticacion.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RolesQueryCQRS {

    @Autowired
    private RolesRepository rolesRepository;

    public Roles getRol(Long id){
        return rolesRepository.findById(id).orElseThrow(() ->{
            return new IllegalStateException("No existe el registro con ID (Roles): " + id);
        });
    }

}
