package com.ejercicio.data;

public abstract class Casa {
	
	  protected int numBa�os;
	  protected int numHabitaciones;
	 
	private Casa() {
		super();
	}
	  
	public Casa(int numHabitaciones, int numBa�os) {
		this();
		this.numHabitaciones = numHabitaciones;
		this.numBa�os = numBa�os;
	}


	public int getNumBa�os() {
		return numBa�os;
	}


	public void setNumBa�os(int numBa�os) {
		this.numBa�os = numBa�os;
	}


	public int getNumHabitaciones() {
		return numHabitaciones;
	}


	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}
	  
	  
	


}
