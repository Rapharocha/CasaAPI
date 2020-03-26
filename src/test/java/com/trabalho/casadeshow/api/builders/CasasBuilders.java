package com.trabalho.casadeshow.api.builders;

import com.trabalho.casadeshow.api.model.Cadastrocasa;

public class CasasBuilders {

	private Cadastrocasa casa;
	
	public CasasBuilders() {
	}
	
	public static CasasBuilders umaCasa() {
		CasasBuilders builders = new CasasBuilders();
		builders.casa.setCodigo(1l);
		builders.casa.setNome("Avenue");
		builders.casa.setEndereco("Rua Presidente Campo Salles");
		
		return builders;	
	}
	
	public CasasBuilders comNome(String nome) {
		casa.setNome(nome);
		return this;
	}
	
	public CasasBuilders comCodigo(Long codigo) {
		casa.setCodigo(codigo);
		return this;
	}
	
	public Cadastrocasa retona() {
		return casa;
	}
}
