package com.trabalho.casadeshow.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@ApiModel(value = "Casa de Show")
@Entity
public class Cadastrocasa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "ID da casa", example = "1")
	private Long codigo;
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cadastrocasa other = (Cadastrocasa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	@NotEmpty(message = "O campo *Casa de Show* não pode estar vazio")
	@Size(max = 50, message = "O campo *Casa de Show* não pode conter mais que 50 caracteres")
	@Size(min = 3, message = "O campo *Casa de Show* deve conter no minímo 3 caracteres")
	@ApiModelProperty( example = "Allianz Parque")
	private String nome;
	
	
	@NotEmpty(message = "O campo *Endereço* não pode estar vazio")
	@Size(max = 50, message = "O campo *Endereço* não pode conter mais que 60 caracteres")
	@Size(min = 8, message = "O campo *Endereço* deve conter no minímo 8 caracteres")
	@ApiModelProperty(example = "Rua Presidente Campo Salles")
	private String endereco;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="cadastrocasa")
	@JsonInclude(Include.NON_NULL)
	private List<Cadastroevento> cadastroevento;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public List<Cadastroevento> getCadastroevento() {
		return cadastroevento;
	}
	public void setCadastroevento(List<Cadastroevento> cadastroevento) {
		this.cadastroevento = cadastroevento;
	}
	

	
	
}
