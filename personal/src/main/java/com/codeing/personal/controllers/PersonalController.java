package com.codeing.personal.controllers;

import com.codeing.personal.dto.UserEventDTO;
import com.codeing.personal.services.RoleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/personal")
@CrossOrigin("*")
public class PersonalController {

    @Autowired
    private RoleManager roleManager;

    @PostMapping("/getPersonal")
    public ResponseEntity<Object> getPersonal(@RequestBody UserEventDTO us){

        Object ob = roleManager.procesarRol(us.getRol(), us);

        return ResponseEntity.ok(ob);

    }

}
