package com.trabalho.casadeshow.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalho.casadeshow.api.model.Cadastrologin;
import com.trabalho.casadeshow.api.repository.UsuarioRepository;
import com.trabalho.casadeshow.api.services.exception.UsuarioNaoEncontradoException;

@Service
public class UsuariosService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Cadastrologin> listar(){
		return usuarioRepository.findAll();
	}
	
	public Cadastrologin buscar(String username){
		Cadastrologin user = usuarioRepository.findByUsername(username);
		if(user == null) {
			throw new UsuarioNaoEncontradoException("O Usuario não pôde ser encontrado");
		}
		return user;
	}
}
