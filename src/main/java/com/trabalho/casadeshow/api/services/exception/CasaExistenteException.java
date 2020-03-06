package com.trabalho.casadeshow.api.services.exception;

public class CasaExistenteException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7205037558710345326L;


	public CasaExistenteException (String mensagem) {
		super(mensagem);
	}
	public CasaExistenteException (String mensagem , Throwable causa) {
		super(mensagem,causa);
	}
}
