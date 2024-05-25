package com.codeing.autenticacion.cqrs;

import com.codeing.autenticacion.entities.Usuario;
import com.codeing.autenticacion.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;

@Component
public class UsuarioQueryCQRS {

    @Autowired
    private UsuarioRepository repository;

    public Usuario getUser(String user) throws AuthenticationException {
        return repository
                .getUser(user)
                .orElseThrow(() -> {
                    return new AuthenticationException("Error de credenciales");
                });
    }


}
