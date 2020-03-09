package com.trabalho.casadeshow.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.trabalho.casadeshow.api.model.Cadastroevento;
import com.trabalho.casadeshow.api.repository.Cadastrocasaeventos;
import com.trabalho.casadeshow.api.services.exception.EventoExistenteException;
import com.trabalho.casadeshow.api.services.exception.EventoNaoEncontradoException;

@Service
public class EventoServices {

	@Autowired
	public Cadastrocasaeventos eventosRepository;
	
	public List<Cadastroevento> listar(){
		return eventosRepository.findAll();
	}
	
	public Optional<Cadastroevento> buscar (Long codigo) {
		Optional<Cadastroevento> evento = eventosRepository.findById(codigo);
		if(evento.isPresent()) {
			return evento;
		}
		throw new EventoNaoEncontradoException("O evento não pôde ser encontrado");
		
	}
	
	public Cadastroevento salvar(Cadastroevento evento) {
		
		if(evento.getCodigo() != null) {
			Optional<Cadastroevento> e = eventosRepository.findById(evento.getCodigo());
			if(e.isPresent()) {
				throw new EventoExistenteException("O evento já existe");
			}
		}
		return eventosRepository.save(evento);
	}
	
	public void deletar(Long codigo) {
		try {
			eventosRepository.deleteById(codigo);;
		} catch (EmptyResultDataAccessException e) {
			throw new EventoNaoEncontradoException("O evento não pôde ser encontrado");
		}
	}
	
	public void VerificarExistenciaEvento(Cadastroevento evento) {
		buscar(evento.getCodigo());
	}
	
	public void atualizar(Cadastroevento evento) {
		VerificarExistenciaEvento(evento);
		eventosRepository.save(evento);
	}
	
	public List<Cadastroevento> listarAscCapacidade(){
		return eventosRepository.findAll(Sort.by(Sort.Direction.ASC,"capacidade"));
	}
	
	public List<Cadastroevento> listarDescCapacidade(){
		return eventosRepository.findAll(Sort.by(Sort.Direction.DESC,"capacidade"));
	}
	
	public List<Cadastroevento> listarAscData(){
		return eventosRepository.findAll(Sort.by(Sort.Direction.ASC,"dataevento"));
	}
	
	public List<Cadastroevento> listarDescData(){
		return eventosRepository.findAll(Sort.by(Sort.Direction.DESC,"dataevento"));
	}
	
	public List<Cadastroevento> listarAscNome(){
		return eventosRepository.findAll(Sort.by(Sort.Direction.ASC,"nomeevento"));
	}
	
	public List<Cadastroevento> listarDescNome(){
		return eventosRepository.findAll(Sort.by(Sort.Direction.DESC,"nomeevento"));
	}
	
	public List<Cadastroevento> listarAscPreco(){
		return eventosRepository.findAll(Sort.by(Sort.Direction.ASC,"valor"));
	}
	
	public List<Cadastroevento> listarDescPreco(){
		return eventosRepository.findAll(Sort.by(Sort.Direction.DESC,"valor"));
	}
} 
