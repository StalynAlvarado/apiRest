package com.example.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginDto;
import com.example.demo.security.JwtUtil;
import com.example.demo.security.UserDetailsImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("login")
public class LoginController {

	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;
	private final UserDetailsImpl detailsImpl;
	
	
	@PostMapping
	public ResponseEntity<?> login(@RequestBody LoginDto request){
		
	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
	UserDetails userDetails=detailsImpl.loadUserByUsername(request.getUsername());
	
	final String token=jwtUtil.generateToken(userDetails);
	HttpHeaders headers=new HttpHeaders();
	headers.set("Authorization", token);
	
		return ResponseEntity.status(200).headers(headers).build();
		
		
	}
}
