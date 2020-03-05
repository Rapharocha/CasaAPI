

package com.trabalho.casadeshow.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho.casadeshow.api.model.Cadastrologin;


public interface UsuarioRepository extends JpaRepository<Cadastrologin,String> {

	Cadastrologin findByUsername(String username);

	
}