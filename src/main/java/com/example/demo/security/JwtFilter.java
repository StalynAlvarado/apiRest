package com.example.demo.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
	
	private final JwtUtil jwtUtil;
	private final UserDetailsImpl detailsImpl;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
		throws ServletException, IOException {
	
	final String reqHeader=request.getHeader("Authorization");
	String token=null;
	String username=null;
		
	if(reqHeader!=null && reqHeader.startsWith("Bearer ")) {
		
		 token=reqHeader.substring(7);
		
		 username=jwtUtil.getUsernameByToken(token);
	}
	if(username!=null) {
		
		UserDetails userDetails=detailsImpl.loadUserByUsername(username);
		if(jwtUtil.validateToken(token, userDetails)) {
			UsernamePasswordAuthenticationToken passwordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());			
		
			passwordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(passwordAuthenticationToken);
		}
	}
	
	filterChain.doFilter(request, response);
	}

}
