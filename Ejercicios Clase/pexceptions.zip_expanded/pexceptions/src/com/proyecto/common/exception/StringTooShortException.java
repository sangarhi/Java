package com.proyecto.common.exception;

//Paso 1. Identificar esta clase commo hija de StringNotValidException
public class StringTooShortException extends StringNotValidException {

	// Paso 2. Indicar un atributo inmutable tipo int llamado "tamanyo"
	private int tamanio;

	// Paso 3. Implementar el constructor adecuado

	public StringTooShortException(String code, String msg,  int tamanio) {
		super(code, msg);
		this.tamanio = tamanio;
	}

	/**
	 * @return the tamanyio
	 */
	public int getTamanio() {
		return tamanio;
	}

}
