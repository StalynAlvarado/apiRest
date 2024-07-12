package com.example.demo.security;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class UserDetailsImpl implements UserDetailsService {

	
	private final UsuarioRepository repository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario=repository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username.concat(" no encotrrado")));
		
			
			Set<GrantedAuthority>  authority=new HashSet<>();
			
			usuario.getRoles().stream()
									.map(r->authority.add(new SimpleGrantedAuthority(r.getNombre()))).collect(Collectors.toSet());
			
			
			UserDetails userDetails=new User(usuario.getUsername(),
					usuario.getPassword(),
					usuario.isActivo(),
					true, true, true, authority);
			return userDetails;
	
	}

}
