package com.trabalho.casadeshow.api.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho.casadeshow.api.model.Cadastrocasa;

public interface Cadastroshow extends JpaRepository<Cadastrocasa,Long>{

	public List<Cadastrocasa> findByNome(String nome);

	public Cadastrocasa findByEndereco(String endereco);

	
	

}
