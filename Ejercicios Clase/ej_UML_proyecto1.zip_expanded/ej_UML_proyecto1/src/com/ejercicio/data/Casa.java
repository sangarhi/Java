package com.ejercicio.data;

public abstract class Casa {
	
	  protected int numBaños;
	  protected int numHabitaciones;
	 
	private Casa() {
		super();
	}
	  
	public Casa(int numHabitaciones, int numBaños) {
		this();
		this.numHabitaciones = numHabitaciones;
		this.numBaños = numBaños;
	}


	public int getNumBaños() {
		return numBaños;
	}


	public void setNumBaños(int numBaños) {
		this.numBaños = numBaños;
	}


	public int getNumHabitaciones() {
		return numHabitaciones;
	}


	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}
	  
	  
	


}
