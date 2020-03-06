package com.trabalho.casadeshow.api.resources;

import java.net.URI;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.trabalho.casadeshow.api.model.Cadastrocasa;
import com.trabalho.casadeshow.api.services.CasaServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(tags = "Gerenciador de Casa de Show")
@RestController
@RequestMapping("/api/casas")
public class CasaResources {

	@Autowired
	private CasaServices casaServices;
	
	@ApiOperation("Listar todas as Casas de Show")
	@GetMapping
	public ResponseEntity<List<Cadastrocasa>> listar(){
		return ResponseEntity.status(HttpStatus.OK).body(casaServices.listar());
	}
	
	@ApiOperation("Salvar Casa de Show")
	@PostMapping
	public ResponseEntity<List<Cadastrocasa>> salvar(@Validated @RequestBody Cadastrocasa casa){
		casa = casaServices.salvar(casa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}")
				                    .buildAndExpand(casa.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation("Buscar uma Casa de Show pelo ID")
	@GetMapping("/{codigo}")
	public ResponseEntity<?> buscar(@PathVariable("codigo") Long codigo){
		return ResponseEntity.status(HttpStatus.OK).body(casaServices.buscar(codigo));
	}
	
	@ApiOperation("Buscar uma Casa de Show pelo nome")
	@GetMapping("/nome/{nome}")
	public ResponseEntity<?> buscarPorNome(@PathVariable("nome") String nome){
		return ResponseEntity.status(HttpStatus.OK).body(casaServices.buscarPorNome(nome));
	}
	
	@ApiOperation("Deletar uma Casa de Show")
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Void> deletar(@PathVariable("codigo") Long codigo){
		casaServices.deletar(codigo);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation("Atualizar uma Casa de Show ")
	@PutMapping
	public ResponseEntity<Void> atualizar(Cadastrocasa casa , Long codigo){
		casa.setCodigo(codigo);
		casaServices.atualizar(casa);
		
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation("Listar as Casas de Show em ordem crescente")
	@GetMapping("/asc")
	public ResponseEntity<List<Cadastrocasa>> listarCrescente(){
		return ResponseEntity.status(HttpStatus.OK).body(casaServices.listarCrescente());
	}
	
	@ApiOperation("Listar as Casas de Show em ordem decrescente")
	@GetMapping("/desc")
	public ResponseEntity<List<Cadastrocasa>> listarDecrescente(){
		return ResponseEntity.status(HttpStatus.OK).body(casaServices.listarDecrescente());
	}
	
}
