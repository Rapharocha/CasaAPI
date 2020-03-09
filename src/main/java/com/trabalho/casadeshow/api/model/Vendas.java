package com.trabalho.casadeshow.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import io.swagger.annotations.ApiModelProperty;


@Entity
public class Vendas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "ID da venda", example = "1")
	private Long id;
	
	@ApiModelProperty(value = "Quantidade de ingressos comprado pelo usuário.", example = "1")
	private Integer ingressosComprados;
	
	@ApiModelProperty(value = "Valor total da compra do usuário", example = "R$ 500,00")
	private Double valorTotal;
	
	@ApiModelProperty(value = "O evento que o usuário comprou", example = "Gustavo Lima")
	@OneToOne
	private Cadastroevento evento;
	
	@ApiModelProperty(value = "O usuário comprador", example = "Raphael Rocha")
	@ManyToOne
	private Cadastrologin usuario;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getIngressosComprados() {
		return ingressosComprados;
	}
	public void setIngressosComprados(int ingressosComprados) {
		this.ingressosComprados = ingressosComprados;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Cadastroevento getEvento() {
		return evento;
	}
	public void setEvento(Cadastroevento evento) {
		this.evento = evento;
	}
	public Cadastrologin getUsuario() {
		return usuario;
	}
	public void setUsuario(Cadastrologin usuario) {
		this.usuario = usuario;
	}
	
}
