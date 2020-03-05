package com.trabalho.casadeshow.api.services.exception;

public class EventoNaoEncontradoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3178343613676139235L;

	public EventoNaoEncontradoException (String mensagem) {
		super(mensagem);
	}
	public EventoNaoEncontradoException (String mensagem , Throwable causa) {
		super(mensagem,causa);
	}
}
