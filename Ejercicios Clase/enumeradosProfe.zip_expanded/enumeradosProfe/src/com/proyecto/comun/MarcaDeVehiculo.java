package com.proyecto.comun;

public enum MarcaDeVehiculo {
	
	FORD(Colores.BLANCO), 
	TOYOTA(Colores.AZUL), 
	SUZUKI(Colores.NEGRO), 
	RENAULT(Colores.GRIS), 
	SEAT(Colores.ROJO);
	
	private Colores colores;
	private String modelo;
	
	
	
	private MarcaDeVehiculo() {
		this.colores = Colores.BLANCO;
		this.modelo = "BERLINA";
	}

	private MarcaDeVehiculo(Colores color) {
		this.colores = color;
		this.modelo = "BERLINA";
	}

	private MarcaDeVehiculo(Colores colores, String modelo) {
		this.colores = colores;
		this.modelo = modelo;
	}

	private MarcaDeVehiculo(String modelo) {
		this.colores = Colores.BLANCO;
		this.modelo = modelo;
	}

	/**
	 * @return the colores
	 */
	public Colores getColores() {
		return colores;
	}

	/**
	 * @param colores the colores to set
	 */
	public void setColores(Colores colores) {
		this.colores = colores;
	}
	
	

}
