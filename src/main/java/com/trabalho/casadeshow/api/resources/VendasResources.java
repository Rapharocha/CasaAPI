package com.trabalho.casadeshow.api.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.casadeshow.api.model.Vendas;
import com.trabalho.casadeshow.api.services.VendasServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Gerenciamento de Vendas")
@RestController
@RequestMapping("/api/vendas")
public class VendasResources {

	@Autowired
	private VendasServices vendasServices;
	
	@ApiOperation("Listar vendas")
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Vendas>> listar(){
		
		return ResponseEntity.status(HttpStatus.OK).body(vendasServices.listar());
	}
	
	@ApiOperation("Buscar vendas por ID")
	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable("id") Long id){
		Optional<Vendas> vendas = vendasServices.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(vendas);
	}
}
