package com.codeing.personal.services;

import com.codeing.personal.dto.*;
import com.codeing.personal.entities.*;
import com.codeing.personal.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class RoleManager {

    private Persona p;
    private final Map<String, Function<UserEventDTO, Object>> map = new HashMap<>();

    @Autowired
    private ServiceClient client;

    public RoleManager(
            IAlumnoService iAlumnoService,
            IPersonaService iPersonaService,
            IDocenteService iDocenteService,
            IDirectivoService iDirectivoService,
            IEscolaresService iEscolaresService,
            IPadreService iPadreService
    ) {


        map.put("Alumno", (us) -> {
            Alumno alumno = iAlumnoService.getAlumnoById(us.getUser());
            p = iPersonaService.getPersona(alumno.getIdPersona());

            AlumnoDTO alumnoDTO = new AlumnoDTO();
            alumnoDTO.setMatricula(alumno.getMatricula());
            alumnoDTO.setPersona(p);
            alumnoDTO.setIdGrupo(alumno.getIdGrupo());

            return alumnoDTO;
        });

        map.put("Docente", (us) -> {
            DocenteDTO dDTO  = iDocenteService.getDocenteById(us.getUser());

            return dDTO;
        });

        map.put("Directivo", (us) -> {
            Directivo directivo = iDirectivoService.getDirectivo(us.getUser());
            p = iPersonaService.getPersona(directivo.getIdPersona());

            EntidadDTO entidadDTO = new EntidadDTO();
            entidadDTO.setMatricula(directivo.getMatricula());
            entidadDTO.setPersona(p);

            return entidadDTO;
        });

        map.put("Escolares", (us) -> {
            Escolares escolares = iEscolaresService.getEscolares(us.getUser());
            p = iPersonaService.getPersona(escolares.getIdPersona());

            EntidadDTO entidadDTO = new EntidadDTO();
            entidadDTO.setMatricula(escolares.getMatricula());
            entidadDTO.setPersona(p);

            return entidadDTO;
        });

        map.put("Padre", (us) -> {
            Padre padre = iPadreService.getPadre(us.getId());
            p = iPersonaService.getPersona(padre.getIdPersona());

            PadreDTO padreDTO = new PadreDTO();

            padreDTO.setIdPadre(padre.getIdPadre());
            padreDTO.setPersona(p);

            return padreDTO;
        });
    }

    public Object procesarRol(String rol, UserEventDTO usuario) {

        Function<UserEventDTO, Object> proRol = map.getOrDefault(rol, us -> {
            throw new IllegalStateException("Error en el rol: " + rol);
        });

        return proRol.apply(usuario);

    }

}
