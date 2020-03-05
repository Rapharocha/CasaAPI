package com.trabalho.casadeshow.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.trabalho.casadeshow.api.model.Cadastrocasa;
import com.trabalho.casadeshow.api.repository.Cadastroshow;
import com.trabalho.casadeshow.api.services.exception.CasaNaoEncontradaException;
import com.trabalho.casadeshow.api.services.exception.EventoExistenteException;

@Service
public class CasaServices {

    @Autowired
	public Cadastroshow cadastroshow;
	
	
	
	public List<Cadastrocasa> listar(){
		return cadastroshow.findAll();
	}
	
	public Cadastrocasa salvar(Cadastrocasa casa) {
		if(casa.getCodigo() != null) {
			Optional<Cadastrocasa> e = cadastroshow.findById(casa.getCodigo());
			if(e.isPresent()) {
				throw new EventoExistenteException("O evento já existe");
			}
		}
		return cadastroshow.save(casa);
	}
	
	public Optional<Cadastrocasa> buscar( Long codigo) {
		Optional<Cadastrocasa> casa = cadastroshow.findById(codigo);
		if(casa.isEmpty()) {
			throw new CasaNaoEncontradaException("Casa não pôde ser encontrada");
		}
		return casa;
	}
	
	public Cadastrocasa buscarPorNome(String nome) {
		Cadastrocasa casa = cadastroshow.findByNome(nome);
		if(casa == null) {
			throw new CasaNaoEncontradaException("Casa não pôde ser encontrada");
		}
		return casa;
	}
	
    public List<Cadastrocasa> listarCrescente(){
    	return cadastroshow.findAll(Sort.by(Sort.Direction.ASC,"nome"));
    }
	
    public List<Cadastrocasa> listarDecrescente(){
    	return cadastroshow.findAll(Sort.by(Sort.Direction.DESC,"nome"));
    }
	
	
	public void deletar (Long codigo) {
	   try {
		   cadastroshow.deleteById(codigo);
	} catch (EmptyResultDataAccessException e) {
		throw new CasaNaoEncontradaException("Casa não pôde ser encontrada");
	}
		
	}
	
	public void atualizar(Cadastrocasa casa) {
		VerificarExistencia(casa);
		cadastroshow.save(casa);
	}
	
	public void VerificarExistencia(Cadastrocasa casa) {
	 	buscar(casa.getCodigo());
	}

	
	
	

	
}