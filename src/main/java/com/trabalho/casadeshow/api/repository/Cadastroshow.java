package com.trabalho.casadeshow.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho.casadeshow.api.model.Cadastrocasa;

public interface Cadastroshow extends JpaRepository<Cadastrocasa,Long>{

	public Cadastrocasa findByNome(String nome);

	

}
