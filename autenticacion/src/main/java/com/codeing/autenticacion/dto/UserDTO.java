package com.codeing.autenticacion.dto;

import com.codeing.autenticacion.entities.Roles;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
public class UserDTO {
    private Long id;
    private String nombre;
    private Roles rol;
	private String token;
}
