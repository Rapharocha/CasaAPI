package com.trabalho.casadeshow.api.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.trabalho.casadeshow.api.model.Cadastroevento;
import com.trabalho.casadeshow.api.services.EventoServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api( tags = "Gerenciador de Eventos")
@RestController
@RequestMapping("/api/eventos")
public class EventoResources {

	@Autowired
	public EventoServices eventoServices;
	
	@ApiOperation("Listar todos eventos")
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Cadastroevento>> listar(){
		return ResponseEntity.status(HttpStatus.OK).body(eventoServices.listar());
	}
	
	@ApiOperation("Buscar um evento pelo seu ID")
	@GetMapping("/{codigo}")
	public ResponseEntity<?> buscar(@PathVariable("codigo") Long codigo){
		Optional<Cadastroevento> evento = eventoServices.buscar(codigo);
		return ResponseEntity.status(HttpStatus.OK).body(evento);
	}
	
	@ApiOperation("Salvar um evento")
	@PostMapping
	public ResponseEntity<Void> salvar(@Validated @RequestBody Cadastroevento evento){
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}").buildAndExpand(evento.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation("Atualizar um evento")
	@PutMapping("/{codigo}")
	public ResponseEntity<Void> atualizar( @RequestBody Cadastroevento evento ,@PathVariable("codigo") Long codigo){
		evento.setCodigo(codigo);
		eventoServices.atualizar(evento);
		
		return ResponseEntity.noContent().build();
	}
	@ApiOperation("Deletar um evento")
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Void> deletar(@PathVariable("codigo") Long codigo){
		eventoServices.deletar(codigo);
		return ResponseEntity.noContent().build();
	}
	@ApiOperation("Listar eventos pela ordem crescente da capacidade")
	@GetMapping("/capacidade/asc")
	public ResponseEntity<List<Cadastroevento>> listarAscCapacidade(){
		return ResponseEntity.status(HttpStatus.OK).body(eventoServices.listarAscCapacidade());
	}
	@ApiOperation("Listar eventos pela ordem decrescente da capacidade") 
	@GetMapping("/capacidade/desc")
	public ResponseEntity<List<Cadastroevento>> listarDescCapacidade(){
		return ResponseEntity.status(HttpStatus.OK).body(eventoServices.listarDescCapacidade());
	}
	@ApiOperation("Listar eventos pela ordem crescente da data")
	@GetMapping("/data/asc")
	public ResponseEntity<List<Cadastroevento>> listarAscData(){
		return ResponseEntity.status(HttpStatus.OK).body(eventoServices.listarAscData());
	}
	@ApiOperation("Listar eventos pela ordem decrescente da data")
	@GetMapping("/data/desc")
	public ResponseEntity<List<Cadastroevento>> listarDescData(){
		return ResponseEntity.status(HttpStatus.OK).body(eventoServices.listarDescData());
	}
	@ApiOperation("Listar eventos pela ordem crescente do nome")
	@GetMapping("/nome/asc")
	public ResponseEntity<List<Cadastroevento>> listarAscNome(){
		return ResponseEntity.status(HttpStatus.OK).body(eventoServices.listarAscNome());
	}
	@ApiOperation("Listar eventos pela ordem decrescente do nome")
	@GetMapping("/nome/desc")
	public ResponseEntity<List<Cadastroevento>> listarDescNome(){
		return ResponseEntity.status(HttpStatus.OK).body(eventoServices.listarDescNome());
	}
	@ApiOperation("Listar eventos pela ordem crescente do preço")
	@GetMapping("/preco/asc")
	public ResponseEntity<List<Cadastroevento>> listarAscPreco(){
		return ResponseEntity.status(HttpStatus.OK).body(eventoServices.listarAscPreco());
	}
	@ApiOperation("Listar eventos pela ordem decrescente do preço")
	@GetMapping("/preco/desc")
	public ResponseEntity<List<Cadastroevento>> listarDescPreco(){
		return ResponseEntity.status(HttpStatus.OK).body(eventoServices.listarDescPreco());
	}
	
	
	
}
