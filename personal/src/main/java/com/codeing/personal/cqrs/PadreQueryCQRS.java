package com.codeing.personal.cqrs;

import com.codeing.personal.entities.Padre;
import com.codeing.personal.repository.PadreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PadreQueryCQRS {

    @Autowired
    private PadreRepository padreRepository;

    public Padre getPadre(Long id){
        return padreRepository.getPadre(id).orElseThrow(() ->{
            return new IllegalStateException("No existe el registro con ID (Padre): " + id);
        });
    }
}
