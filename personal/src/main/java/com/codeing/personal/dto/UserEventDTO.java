package com.codeing.personal.dto;

import lombok.*;

@Getter @Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
public class UserEventDTO {
    private Long id;
    private String user;
    private String rol;
}
