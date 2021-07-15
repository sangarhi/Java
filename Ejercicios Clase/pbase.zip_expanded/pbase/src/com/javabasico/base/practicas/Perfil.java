package com.javabasico.base.practicas;

import java.io.Serializable;

public class Perfil implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Construir un Bean Perfil, que tenga como atributos  el identificador  y el nombre
	
	private String identificador;
	private String nombre;
	
	public Perfil() {
		super();
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
