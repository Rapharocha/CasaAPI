package com.trabalho.casadeshow.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Role implements GrantedAuthority{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@JsonIgnore
	private String nomeRole;
	
	@ManyToMany
	private List<Cadastrologin>usuarios;
	
	@JsonProperty("autorizado")
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.getNomeRole();
	}

	public String getNomeRole() {
		return nomeRole;
	}

	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}


	private List<Cadastrologin> getUsuarios() {
		return usuarios;
	}

	private void setUsuarios(List<Cadastrologin> usuarios) {
		this.usuarios = usuarios;
	}

}
