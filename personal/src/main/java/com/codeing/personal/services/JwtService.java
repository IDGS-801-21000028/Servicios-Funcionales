package com.codeing.personal.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {

	private Claims getClaims(String token){
		return Jwts
				.parser()
				.verifyWith(generateKey())
				.build()
				.parseSignedClaims(token)
				.getPayload();
	}

	public boolean validateToken(String token){
		try{
			Claims claims = getClaims(token);
			System.out.println(claims);
			return true;

		}catch(Exception e){
			return false;
		}
	}

	private SecretKey generateKey(){
		String SECRET_KEY = "RVNUTyBlcyB1bmEgQ2xhdmUgU0VDUkVUQSBVU2FkQSBwYXJhIEpXVDEyMyogRElFR08gREFMQU4gOTg3NjU0MzIxKg==";
		byte[] secretAsByte = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(secretAsByte);
	}

}