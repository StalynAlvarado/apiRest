package com.example.demo.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtUtil {

	@Value("${jwt.secret}")
	private String JWT_TOKEN;
	
	@Value("${token.time}")
	private Long JWT_TOKEN_TIME;
	
	
	public String generateToken(UserDetails details) {
		
		Map<String, Object> claims=new HashMap<>();
		claims.put("Rol", details.getAuthorities().stream().map(r->r.getAuthority()).collect(Collectors.toSet()));
		
	String token=Jwts.builder()
			.claims(claims)
			.subject(details.getUsername())
			.signWith(signKey())
			.issuedAt(new Date(System.currentTimeMillis()))
			.expiration(new Date(System.currentTimeMillis()+JWT_TOKEN_TIME))
			.compact();
		
		return token;
	}
	
	
	public Claims getClaims(String token) {
		try {
			return Jwts.parser().verifyWith(signKey()).build().parseSignedClaims(token).getPayload();
			
		} catch (JwtException e) {
			throw new JwtException(e.getMessage());
		}
	}
	
	private SecretKey signKey() {
		return Keys.hmacShaKeyFor(JWT_TOKEN.getBytes());
	}
	
	public String getUsernameByToken(String token) {
		
		return getClaims(token).getSubject();
	}
	
	public boolean tokenExpired(String token){
		
		Date expiration = getClaims(token).getExpiration();
		 
		 return expiration.before(new Date());
	}
	
	public boolean validateToken(String token,UserDetails details) {
		final String userToken= getUsernameByToken(token);
		final String userDetail=details.getUsername();
		
			return (userToken.equals(userDetail)&& !tokenExpired(token));
	
		
	}
	
}
