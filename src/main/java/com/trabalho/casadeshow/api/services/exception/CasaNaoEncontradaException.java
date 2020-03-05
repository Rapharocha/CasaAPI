package com.trabalho.casadeshow.api.services.exception;

public class CasaNaoEncontradaException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7297954582401135168L;
	
	public CasaNaoEncontradaException (String mensagem) {
		super(mensagem);
	}
	public CasaNaoEncontradaException (String mensagem , Throwable causa) {
		super(mensagem,causa);
	}
}
