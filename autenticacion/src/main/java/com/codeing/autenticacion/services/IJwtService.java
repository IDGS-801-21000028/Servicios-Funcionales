package com.codeing.autenticacion.services;

import com.codeing.autenticacion.entities.Usuario;
import java.util.Map;

public interface IJwtService {
    String generateToken(Usuario user, Map<String, Object> extraClaims);
}
