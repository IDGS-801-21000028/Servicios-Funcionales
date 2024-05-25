package com.codeing.personal.services;

import com.codeing.personal.cqrs.DocenteQueryCQRS;
import com.codeing.personal.dto.DocenteDTO;
import com.codeing.personal.entities.Docente;
import com.codeing.personal.entities.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocenteService implements IDocenteService{

    @Autowired
    private DocenteQueryCQRS docenteQueryCQRS;

    @Autowired
    private IPersonaService iPersonaService;

    @Autowired
    private ServiceClient client;

    @Override
    public List<DocenteDTO> getAll() {

        List<Docente> docentes = docenteQueryCQRS.getAll();

        List<DocenteDTO> listDocentes = new ArrayList<>();

        docentes.forEach(d ->{

            DocenteDTO dDTO = new DocenteDTO();

            Persona p = iPersonaService.getPersona(d.getIdPersona());

            String endpoint = "api/carrera/getCarrera/" + d.getIdCarrera();

            client.urlBase = "http://localhost:8083/";

		    Object response = client.callGetService(endpoint, Object.class);

            dDTO.setMatricula(d.getMatricula());
            dDTO.setPersona(p);
            dDTO.setCarrera(response);

            listDocentes.add(dDTO);

        });

        return listDocentes;
    }

    @Override
    public DocenteDTO getDocenteById(String id){

        Docente d = docenteQueryCQRS.getDocenteById(id);

        DocenteDTO dDTO = new DocenteDTO();

        Persona p = iPersonaService.getPersona(d.getIdPersona());

        String endpoint = "api/carrera/getCarrera/" + d.getIdCarrera();

        client.urlBase = "http://localhost:8083/";

        Object response = client.callGetService(endpoint, Object.class);

        dDTO.setMatricula(d.getMatricula());
        dDTO.setPersona(p);
        dDTO.setCarrera(response);

        return dDTO;
    }

    @Override
    public List<DocenteDTO> getDocenteByCarrera(Long carrera) {

        List<Docente> docentes = docenteQueryCQRS.getDocenteByCarrea(carrera);

        List<DocenteDTO> listDocente = new ArrayList<>();

        docentes.forEach(d -> {

            Persona p = iPersonaService.getPersona(d.getIdPersona());

            String endpoint = "api/carrera/getCarrera/" + d.getIdCarrera();

            client.urlBase = "http://localhost:8083/";

            Object response = client.callGetService(endpoint, Object.class);

            DocenteDTO docenteDTO = new DocenteDTO();

            docenteDTO.setMatricula(d.getMatricula());
            docenteDTO.setPersona(p);
            docenteDTO.setCarrera(response);

            listDocente.add(docenteDTO);
        });


        return listDocente;
    }
}
