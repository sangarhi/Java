package com.herencia.ln.interfaces;

public interface IAnimal {

	// Estas tres declaraciones son equivlentes: p�blicas y abstractas
	//Se sobreentiende que es p�blico y abstracto
	void nacer();

	abstract void vivir();
	//Normalmente se declaran as�, y la palabra reservada "abstract" se obvia.
	public void morir();

}
