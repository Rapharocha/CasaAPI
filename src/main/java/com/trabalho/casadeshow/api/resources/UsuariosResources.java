package com.trabalho.casadeshow.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.casadeshow.api.model.Cadastrologin;
import com.trabalho.casadeshow.api.services.UsuariosService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(tags = "Gerenciamento de Usuários")
@RestController
@RequestMapping("/api/users")
public class UsuariosResources {

	@Autowired
	private UsuariosService usuarioService;
	
	@ApiOperation("Listar usuários")
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Cadastrologin>> listar(){
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.listar());
	}
	
	@ApiOperation("Buscar um usuários")
	@GetMapping("/{username}")
	public ResponseEntity<?> buscar(@PathVariable("username") String username){
		Cadastrologin user = usuarioService.buscar(username);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	
}
