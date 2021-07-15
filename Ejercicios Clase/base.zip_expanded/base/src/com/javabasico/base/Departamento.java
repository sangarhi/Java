package com.javabasico.base;

//Clase modelo de un Bean
public class Departamento {
	
	//Norma 1: Todos un atributos deben ser privados
	private Long id;
	private String nombre;
	
	//Norma 2: Debe tener declarado un constructor por  defecto
	public Departamento() {
		super();
	}
	
	//Norma 3: Deben estar disponibles los m�todos de acceso
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	//Norma 4: No DEBEN existir m�todos de negocio
	
	
	//El m�todo toString se hace la vista gorda con �l
	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	

}
