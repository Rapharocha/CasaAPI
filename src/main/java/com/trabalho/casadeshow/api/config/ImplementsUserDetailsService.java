package com.trabalho.casadeshow.api.config;




import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.trabalho.casadeshow.api.model.Cadastrologin;
import com.trabalho.casadeshow.api.repository.UsuarioRepository;

@Service
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService{

	
	@Autowired
    private UsuarioRepository ur;
	
	  @Override 
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		  Cadastrologin usuario = ur.findByUsername(username);
		  
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		
     	return new User(usuario.getUsername(),usuario.getPassword(),true,true,true,true,usuario.getAuthorities());
	}



}
