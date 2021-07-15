package com.herencia.ln.interfaces;

public interface IAnimal {

	// Estas tres declaraciones son equivlentes: públicas y abstractas
	//Se sobreentiende que es público y abstracto
	void nacer();

	abstract void vivir();
	//Normalmente se declaran así, y la palabra reservada "abstract" se obvia.
	public void morir();

}
