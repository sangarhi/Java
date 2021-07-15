package com.ejercicio.data;

public class Chalet extends Casa {
	
    private int numPlantas;
	
	public Chalet(int numBa�os, int numHabitaciones) {
		super(Constantes.NUM_HABITACIONES_DEFECTO, Constantes.NUM_BA�OS_DEFECTO);
	}

	public int getNumPlantas() {
		return numPlantas;
	}

	public void setNumPlantas(int numPlantas) {
		this.numPlantas = numPlantas;
	}
	
	
	

}
