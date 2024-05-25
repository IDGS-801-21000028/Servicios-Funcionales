package com.codeing.personal.services;

import com.codeing.personal.cqrs.PadreQueryCQRS;
import com.codeing.personal.entities.Padre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PadreService implements IPadreService{

    @Autowired
    private PadreQueryCQRS padreQueryCQRS;

    @Override
    public Padre getPadre(Long id) {
        return padreQueryCQRS.getPadre(id);
    }
}
