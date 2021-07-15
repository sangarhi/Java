package com.herencia.data;

import java.io.Serializable;

//Si implementamos aqui Serializable (que es la unica interfaz que permiten implementar 
//los Beans) este comportamiento lo heredarian TODAS las clases que extiendan de animal
public abstract class Animal implements Serializable{
	
	
	
	//Se marca como protegido en vez de privado para que 
	//puedan acceder  las hijas y que sean  ellas las que
	//implementen los getter/setter
	protected boolean mcaGenero;
	protected int edad;
	
	public Animal() {
		// La invocaci�n a super() se va a realizar
		// se indique explic�tamente o no
		
	}

	//Getter/Setter Tambi�n esta bien visto, que los getter/setter 
    //se implementen en las clase concretas
	public boolean isMcaGenero() {
		return mcaGenero;
	}

	public void setMcaGenero(boolean mcaGenero) {
		this.mcaGenero = mcaGenero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	

}
