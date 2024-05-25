package com.codeing.personal.services;

import com.codeing.personal.cqrs.DirectivoQueryCQRS;
import com.codeing.personal.entities.Directivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectivoService implements IDirectivoService {

    @Autowired
    private DirectivoQueryCQRS directivoQueryCQRS;

    @Override
    public Directivo getDirectivo(String id) {
        return directivoQueryCQRS.getDirectivo(id);
    }
}
