package com.tipoLambda.data;

public class Casa {
	
	private int numHabitaciones;
	private int numBa�os;
	private String nombre;
	
	public Casa() {
		super();
		this.nombre="Mi casa";
	}
	
	public int getNumHabitaciones() {
		return numHabitaciones;
	}
	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}
	public int getNumBa�os() {
		return numBa�os;
	}
	public void setNumBa�os(int numBa�os) {
		this.numBa�os = numBa�os;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Casa [numHabitaciones=" + numHabitaciones + ", numBa�os=" + numBa�os + ", nombre=" + nombre + "]";
	}
	
	

}
