package com.trabalho.casadeshow.api.services.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8907960097479765594L;
	public UsuarioNaoEncontradoException (String mensagem) {
		super(mensagem);
	}
	public UsuarioNaoEncontradoException (String mensagem , Throwable causa) {
		super(mensagem,causa);
	}
}
