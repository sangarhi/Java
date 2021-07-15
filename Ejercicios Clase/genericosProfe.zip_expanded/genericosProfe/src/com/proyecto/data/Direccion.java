package com.proyecto.data;

import java.io.Serializable; // java.io: entrada y salida de datos.

/**
 * Qué es el departamento: los atributos que definen ese Departamento.
 * 
 * Este tipo de clase se les denomina "bean" o "POJO".
 * 
 * @author Javier
 *
 */
@SuppressWarnings("serial")  // Ignorar avisos.
public class Direccion implements Serializable {
	
	private Integer idDepartamento; // Usar los "wrapper" (no tipos primitivos), para que no ocupe memoria hasta que se use. 
	private String nombre;

	// Constructor por defecto.
	public Direccion() {
		super();
	}

	// Getters/Setters
	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// toString() y equals() normalmente no tiene sobrescritos estos métodos.
	
	// No tiene métodos de negocio.
	
}
