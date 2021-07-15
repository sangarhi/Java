package com.proyecto.ln;

public class Saludo implements ISaludar {
	
	private String nombre;

	public Saludo() {
		super();
	}

	@Override
	public void saludar(String nombre) {
		this.nombre=nombre;
		System.out.println("Hola "+nombre);
		
	}

}
