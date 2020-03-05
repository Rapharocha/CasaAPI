package com.trabalho.casadeshow.api.model;



import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Representa um Usuário")
@Entity
public class Cadastrologin implements UserDetails {
    
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@NotEmpty(message = "Username obrigatório")
	@Size(max = 40, message = "O username  não pode contar mais que 40 caracteres.")
	@ApiModelProperty("Representa o Login do Usuário")
	private String username;
	
	@NotEmpty(message = "Nome é Obrigátorio")
	private String nome;
	
	@NotEmpty(message = "Senha obrigatória")
    @Size(min = 8, message = "A senha deve conter no minímo 8 caracteres.")
	@JsonIgnore
	private String password;
	
	@ManyToMany
	@JoinTable( name = "usuarios_roles", joinColumns = @JoinColumn(name = "cadastrologin_id",
	referencedColumnName="username"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName="nomeRole"))
	@ApiModelProperty("Representa as Permissões do Usuário")
	private List<Role>roles;
    
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@JsonProperty("autorizacao")
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return (Collection<? extends GrantedAuthority>)this.roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
    @Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

    @JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	



	
}
