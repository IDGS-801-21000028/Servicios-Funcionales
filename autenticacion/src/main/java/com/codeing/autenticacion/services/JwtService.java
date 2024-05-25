package com.codeing.autenticacion.services;

import com.codeing.autenticacion.entities.*;
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService implements IJwtService {

	@Override
	public String generateToken(Usuario user, Map<String, Object> extraClaims){

		int EXPIRATION_MINUTES = 60;
		Date issuedAt = new Date(System.currentTimeMillis());
		Date expiration = new Date(issuedAt.getTime() + (EXPIRATION_MINUTES * 60 * 1000));

		return Jwts
				.builder()
				.claims(extraClaims)
				.subject(user.getUser())
				.issuedAt(issuedAt)
				.expiration(expiration)
				.signWith(generateKey())
				.compact();
	}

	private SecretKey generateKey(){
		String SECRET_KEY = "RVNUTyBlcyB1bmEgQ2xhdmUgU0VDUkVUQSBVU2FkQSBwYXJhIEpXVDEyMyogRElFR08gREFMQU4gOTg3NjU0MzIxKg==";
		byte[] secretAsByte = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(secretAsByte);
	}

}