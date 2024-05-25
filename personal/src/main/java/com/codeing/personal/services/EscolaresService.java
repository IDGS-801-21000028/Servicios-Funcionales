package com.codeing.personal.services;

import com.codeing.personal.cqrs.EscolaresQueryCQRS;
import com.codeing.personal.entities.Escolares;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EscolaresService implements IEscolaresService{

    @Autowired
    private EscolaresQueryCQRS escolaresQueryCQRS;

    @Override
    public Escolares getEscolares(String id) {
        return escolaresQueryCQRS.getEscolares(id);
    }
}
