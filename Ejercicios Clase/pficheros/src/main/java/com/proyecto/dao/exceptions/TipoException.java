package com.proyecto.dao.exceptions;

public enum TipoException {
	EXCEPCION_GENERAL("Excepci�n General"),
	EXCEPCION_SQL("Excepci�n SQL"),
	ELEMENTO_NO_ENCONTRADO("Elemento no encontrado"),
	ELEMENTO_NO_CREADO("Elemento no creado"),
	ELEMENTO_NO_ACTUALIZADO("Elemento no actualizado"),
	ELEMENTO_NO_ELIMINADO("Elemento no eliminado"),
	ELEMENTO_DUPLICADO("Elemento no duplicado"),
	EXCEPCION_DAO("Excepcion en el dao"),
	OPERACION_NO_REALIZADA("La operaci�n no se ha podido realizar");

	private String mensaje=null;

	private TipoException(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getMensaje() {
		return mensaje;
	}


}
