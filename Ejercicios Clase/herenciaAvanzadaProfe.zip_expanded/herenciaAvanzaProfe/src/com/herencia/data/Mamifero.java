package com.herencia.data;

public abstract class Mamifero extends Animal {

	// Se marca como protegido en vez de privado para que
	// puedan acceder las hijas y que sean ellas las que
	// implementen los getter/setter
	protected boolean mcaPelo;
	protected int numPatas;
	protected boolean mcaPatas;
	protected boolean mcaDomestico;

	public Mamifero() {
		// La invocación a super() se va a realizar
		// se indique explicítamente o no
		super();
	}
	
	//Getter/Setter También esta bien visto, que los getter/setter 
	//se implementen en las clase concretas

	public boolean isMcaPelo() {
		return mcaPelo;
	}

	public void setMcaPelo(boolean mcaPelo) {
		this.mcaPelo = mcaPelo;
	}

	public int getNumPatas() {
		return numPatas;
	}

	public void setNumPatas(int numPatas) {
		this.numPatas = numPatas;
	}

	public boolean isMcaPatas() {
		return mcaPatas;
	}

	public void setMcaPatas(boolean mcaPatas) {
		this.mcaPatas = mcaPatas;
	}

	public boolean isMcaDomestico() {
		return mcaDomestico;
	}

	public void setMcaDomestico(boolean mcaDomestico) {
		this.mcaDomestico = mcaDomestico;
	}
	
	//G
	
	

}
