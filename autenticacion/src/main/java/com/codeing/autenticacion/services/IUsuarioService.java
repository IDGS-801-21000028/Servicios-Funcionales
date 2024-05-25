package com.codeing.autenticacion.services;

import com.codeing.autenticacion.dto.DatosDTO;

import javax.naming.AuthenticationException;

public interface IUsuarioService {
    DatosDTO getUser(String user, String password) throws AuthenticationException;
}
