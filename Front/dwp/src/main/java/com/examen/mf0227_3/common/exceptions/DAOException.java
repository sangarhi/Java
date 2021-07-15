package com.examen.mf0227_3.common.exceptions;

@SuppressWarnings("serial")
public class DAOException extends Exception {

	TipoException tipoExcepcion;

	public DAOException(TipoException tipoExcepcion) {
		super();
		this.tipoExcepcion = tipoExcepcion;
	}

	public TipoException getTipoExcepcion() {
		return tipoExcepcion;
	}

	
	
}
