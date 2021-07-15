package com.ejercicio.data;

public class Piso extends Casa {
	
	private boolean exterior;

	public Piso(int numHabitaciones, int numBaños) {
		super(numHabitaciones, numBaños);
		// TODO Auto-generated constructor stub
	}

	public boolean isExterior() {
		return exterior;
	}

	public void setExterior(boolean exterior) {
		this.exterior = exterior;
	}
	
	

}
