package com.codeing.autenticacion.controllers;

import com.codeing.autenticacion.dto.UserRequestDTO;
import com.codeing.autenticacion.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.Exception;
import java.util.HashMap;
import java.util.Map;

import javax.naming.AuthenticationException;
import com.codeing.autenticacion.utils.JsonUtils;


@RestController
@RequestMapping("api/usuario")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private IUsuarioService service;

    @PostMapping("/login")
    public ResponseEntity<?> getAccess(@RequestBody UserRequestDTO u) {
        try{

            return ResponseEntity.ok(service.getUser(u.getUser(), u.getPassword()));

        } catch (AuthenticationException e){     
    
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(JsonUtils.toJson(errorResponse));

        } catch (Exception e) {

            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(JsonUtils.toJson(errorResponse));
        }
    }

}