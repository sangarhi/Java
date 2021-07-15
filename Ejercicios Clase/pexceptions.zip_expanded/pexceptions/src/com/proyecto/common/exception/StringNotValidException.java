package com.proyecto.common.exception;

public class StringNotValidException extends Exception {
	
	//Paso 1.Indicar atributo protegido de tipo String llamado "code"
	protected String code;
	
	//Paso 2. Construir contructor, que tenga por parametro code
	// y un mensaje para el constructor padre
	public StringNotValidException(String code, String msg) {
		super(msg);
		this.code = code;
	}

}
