package com.codeing.autenticacion.services;

import com.codeing.autenticacion.cqrs.RolesQueryCQRS;
import com.codeing.autenticacion.dto.*;
import com.codeing.autenticacion.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codeing.autenticacion.cqrs.UsuarioQueryCQRS;

import javax.naming.AuthenticationException;
import java.util.HashMap;
import java.util.Map;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioQueryCQRS usuarioCQRS;
    @Autowired
    private RolesQueryCQRS rolesQueryCQRS;
    @Autowired
    private ServiceClient client;
	@Autowired
	private IJwtService jwtService;
    @Autowired
    private IEncryptService encryptService;
	
    @Override
    public DatosDTO getUser(String user, String password) throws AuthenticationException {

        UserDTO usuario = null;
        Object response = null;

        try {
            Usuario us = usuarioCQRS.getUser(user);

            //String clientPassword = encryptService.encryptPassword(password);

            //System.out.println(clientPassword);

            boolean checkPassword = encryptService.verifyPassword(password, us.getPassword());
			
			if(checkPassword){
				Roles r = rolesQueryCQRS.getRol(us.getRol());

				usuario = new UserDTO();

				usuario.setId(us.getId());
				usuario.setNombre(us.getUser());
				usuario.setRol(r);

				UserEventDTO uDTO = new UserEventDTO();

				uDTO.setId(us.getId());
				uDTO.setUser(us.getUser());
				uDTO.setRol(r.getNombre());

				client.urlBase = "http://localhost:8082";

				response = client.callPostService("/api/personal/getPersonal", uDTO, Object.class);

				String token = jwtService.generateToken(us, generateExtraClaims(usuario));

				usuario.setToken(token);
			} else {
				throw new AuthenticationException("Credenciales incorrectas");
			}           

        } catch (AuthenticationException e) {
			throw new AuthenticationException("Error de credenciales");			
		} catch (Exception e){           
			System.out.println(e);			
			throw new RuntimeException("Se produjo un error inesperado");
        }

        return new DatosDTO(usuario, response);
    }
	
	private Map<String, Object> generateExtraClaims(UserDTO user){
		
		Map<String, Object> extraClaims = new HashMap<>();

		extraClaims.put("name", user.getNombre());
		extraClaims.put("rol", user.getRol().getNombre());
		
		return extraClaims;
	}
}
