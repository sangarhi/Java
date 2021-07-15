package com.herencia.data;

public class Leon extends Mamifero {

	// En las clases concretas si que se suele indicar
	// los atributos como privados, a no ser que se piense
	// en que se puede heredar 
	private String procedencia;
	
	public Leon() {
		
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}
	
	

}
