package com.trabalho.casadeshow.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalho.casadeshow.api.model.Vendas;
import com.trabalho.casadeshow.api.repository.VendasRepository;
import com.trabalho.casadeshow.api.services.exception.VendasNaoEncontradaException;

@Service
public class VendasServices {

	@Autowired
	private VendasRepository vendasRepository;
	
	public List<Vendas> listar(){
		return vendasRepository.findAll();
	}
	
	public Optional<Vendas> buscar(Long id) {
		Optional<Vendas> vendas = vendasRepository.findById(id);
		if(vendas.isEmpty()) {
			throw new VendasNaoEncontradaException("vendas não pode ser encontrada");
		}
		return vendas;
	}
}
