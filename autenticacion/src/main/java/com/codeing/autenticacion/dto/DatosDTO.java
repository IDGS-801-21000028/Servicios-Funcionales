package com.codeing.autenticacion.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DatosDTO {
    private UserDTO user;
    private Object content;
}
