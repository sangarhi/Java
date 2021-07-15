package com.proyecto.data;

import com.proyecto.comun.MarcaDeVehiculo;

public class Vehiculo {
	
	private String matricula;
	private MarcaDeVehiculo marca;
	
	public Vehiculo() {
		super();
	}
	public Vehiculo(String matricula, MarcaDeVehiculo marca) {
		super();
		this.matricula = matricula;
		this.marca = marca;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public MarcaDeVehiculo getMarca() {
		return marca;
	}
	public void setMarca(MarcaDeVehiculo marca) {
		this.marca = marca;
	}
	
	
	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", marca=" + marca + "]";
	}
	
	
	
	
}
