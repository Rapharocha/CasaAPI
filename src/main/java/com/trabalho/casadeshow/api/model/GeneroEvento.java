package com.trabalho.casadeshow.api.model;

public enum GeneroEvento {

	AXE("Axé"),
    SERTANEJO("Sertanejo"),
    ROCK("Rock"),
    FUNK("Funk"),
    POP("Pop"),
    ELETRONICO("Eletrônico"),
    SAMBA("Samba");
	
	//atributo
	private String estilo;
	
	//construtor
    GeneroEvento(String estilo){
    	this.estilo = estilo;
    }

    //getter
	public String getEstilo() {
		return estilo;
	}
    
    
	
}
