package com.tipoLambda.data;

public class Casa {
	
	private int numHabitaciones;
	private int numBaños;
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
	public int getNumBaños() {
		return numBaños;
	}
	public void setNumBaños(int numBaños) {
		this.numBaños = numBaños;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Casa [numHabitaciones=" + numHabitaciones + ", numBaños=" + numBaños + ", nombre=" + nombre + "]";
	}
	
	

}
