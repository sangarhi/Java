package com.excepciones.common;

public enum TipoExcepcion {
	RUNTIME_EXCEPTION("Excepcion en tiempo de ejecuci�n"),
	CHECKED_EXCEPTION("Excepcion en tiempo de compilaci�n"),
	GENERAL("Excepcion general no controlada");

	private String descripcion;
	
	private TipoExcepcion(String descripcion) {
		this.descripcion=descripcion;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	
	
	
}
