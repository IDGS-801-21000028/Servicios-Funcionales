package com.codeing.autenticacion.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter @Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
public class UserRequestDTO {
    private String user;
    private String password;
}
