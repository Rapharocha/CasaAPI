package com.trabalho.casadeshow.api.services.exception;

public class EventoExistenteException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5108231742072891972L;

	public EventoExistenteException (String mensagem) {
		super(mensagem);
	}
	public EventoExistenteException (String mensagem , Throwable causa) {
		super(mensagem,causa);
	}
}
