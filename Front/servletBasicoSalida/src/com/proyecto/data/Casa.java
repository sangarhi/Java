package com.proyecto.data;

public class Casa {
	
	private Long id=0l;
	private String nombre="Mi Casa";




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

	@Override
	public String toString() {
		return "Casa [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	

}
