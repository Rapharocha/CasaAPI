package com.trabalho.casadeshow.api.services.exception;

public class VendasNaoEncontradaException extends RuntimeException{

	private static final long serialVersionUID = -8907960097479765594L;
	
	public VendasNaoEncontradaException (String mensagem) {
		super(mensagem);
	}
	public VendasNaoEncontradaException (String mensagem , Throwable causa) {
		super(mensagem,causa);
	}
}
