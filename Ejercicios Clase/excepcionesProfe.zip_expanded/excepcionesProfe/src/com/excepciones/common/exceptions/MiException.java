package com.excepciones.common.exceptions;

import com.excepciones.common.TipoExcepcion;

//Lo único que es necesario es que EXTIENDA DE EXCEPTION
@SuppressWarnings("serial")
public class MiException extends Exception {
	
	//Estos atributos son opcionales
	//No es necesario el enum, se puede poner lo que quiera
	private int code;
	private TipoExcepcion tipo;
	
	public MiException(int code, TipoExcepcion tipo,String mensaje) {
		super(mensaje);
		this.code = code;
		this.tipo = tipo;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the tipo
	 */
	public TipoExcepcion getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoExcepcion tipo) {
		this.tipo = tipo;
	}
	
	
	

}
