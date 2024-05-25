package com.codeing.personal.cqrs;

import com.codeing.personal.entities.Directivo;
import com.codeing.personal.repository.DirectivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectivoQueryCQRS {

    @Autowired
    private DirectivoRepository directivoRepository;

    public Directivo getDirectivo(String id){
        return directivoRepository.findById(id).orElseThrow(() ->{
            return new IllegalStateException("No existe el registro con ID (Directivo): " + id);
        });
    }


}
