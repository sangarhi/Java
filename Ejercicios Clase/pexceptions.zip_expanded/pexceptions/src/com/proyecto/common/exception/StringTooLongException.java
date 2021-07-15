package com.proyecto.common.exception;

//Paso 1. Identificar esta clase commo hija de StringNotValidException
public class StringTooLongException extends StringNotValidException {

	//Paso 2. Indicar un atributo inmutable tipo int llamado "tamanyo"
	private int tamanio;
	
	//Paso 3. Implementar el constructor adecuado	
	public StringTooLongException(String code, String msg, int tamanio) {
		super(code, msg);
		this.tamanio = tamanio;
	}

	/**
	 * @return the tamanyo
	 */
	public int getTamanio() {
		return tamanio;
	}
	
	
}
