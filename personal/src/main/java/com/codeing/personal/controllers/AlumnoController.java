package com.codeing.personal.controllers;

import com.codeing.personal.dto.AlumnoDTO;
import com.codeing.personal.services.IAlumnoService;
import com.codeing.personal.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;
import java.util.Map;
import com.codeing.personal.utils.JsonUtils;

@RestController
@RequestMapping("api/alumno")
@CrossOrigin("*")
public class AlumnoController {

    @Autowired
    private IAlumnoService service;
	
	@Autowired
	private JwtService jwt;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(@RequestHeader("Authorization") String authorizationHeader) {		
		
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
			String token = authorizationHeader.substring(7);
			
			if(jwt.validateToken(token)){
				List<AlumnoDTO> alumnos = service.getAll();
				return ResponseEntity.ok(alumnos);
			} else {
				Map<String, String> errorResponse = new HashMap<>();
				errorResponse.put("ERROR", "NOT ACCESS DATA");
				
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(JsonUtils.toJson(errorResponse));
			}
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token no proporcionado en el encabezado");
		}
		
        
    }

    @GetMapping("/getAlumnosGrupo/{idGrupo}")
    public List<AlumnoDTO> getAlumnosGrupo(@PathVariable String idGrupo) {
        return service.getAlumnosGrupo(idGrupo);
    }

    @GetMapping("/getAlumnosCarrera/{idCarrera}")
    public List<AlumnoDTO> getAlumnosCarrera(@PathVariable String idCarrera) {

        //Recibir los idsgrupos
        List<Long> idsGrupo = new ArrayList<>();

        idsGrupo.add(1L);
        idsGrupo.add(2L);
        idsGrupo.add(3L);

        return service.findAlumnosByIdGrupoIn(idsGrupo);
    }

}
