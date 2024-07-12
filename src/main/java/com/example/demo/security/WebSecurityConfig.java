package com.example.demo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
	
	private final UserDetailsImpl detailsImpl;
	
	private final PasswordEncoder encoder;
	
	private final JwtFilter jwtFilter;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
		
		return	 security
				.csrf(c->c.disable())
				.authorizeHttpRequests(a->a
						.requestMatchers("/login").permitAll()
						.requestMatchers(HttpMethod.GET).hasAnyAuthority("ADMIN","USER")
						.requestMatchers(HttpMethod.POST).hasAnyAuthority("ADMIN","USER")
						.requestMatchers(HttpMethod.PUT).hasAnyAuthority("ADMIN")
						.requestMatchers(HttpMethod.DELETE).hasAuthority("ADMIN")
						
						)
				.sessionManagement(s->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.formLogin(l->l.disable())
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
				 .build();
	}
	
	@Bean 
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
	
	  @Bean public AuthenticationProvider authenticationProvider() {
	  DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
	  provider.setUserDetailsService(detailsImpl);
	  provider.setPasswordEncoder(encoder);
	  
	  return provider; }

}
