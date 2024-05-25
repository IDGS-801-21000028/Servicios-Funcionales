package com.codeing.grupos.dto;

import com.codeing.grupos.entities.Feriado;
import com.codeing.grupos.entities.Periodo;
import lombok.*;

@Getter @Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
public class FeriadoPeriodoDTO {
  private Feriado feriado;
  private Periodo periodo;
}