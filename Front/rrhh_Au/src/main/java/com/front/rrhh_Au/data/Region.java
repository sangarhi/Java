package com.front.rrhh_Au.data;

public class Region {
	
	private Integer id;
	private String nombre;
	
	public Region() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Region [id=" + id + ", nombre=" + nombre + "]";
	};
	
	

}
