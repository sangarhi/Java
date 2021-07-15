package com.herencia.data;

public class Perro extends Mamifero {
	
	//En las clases concretas si que se suele indicar
	//los atributos como privados, a no ser que se piense
	//en que se puede heredar como es el caso
	protected int tamanio;
	protected int tipoHocico;
	protected int tipoPelo;	
	
	public Perro() {
		
	}
	
	//Getter/Setter


	public int getTamanio() {
		return tamanio;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}

	public int getTipoHocico() {
		return tipoHocico;
	}

	public void setTipoHocico(int tipoHocico) {
		this.tipoHocico = tipoHocico;
	}

	public int getTipoPelo() {
		return tipoPelo;
	}

	public void setTipoPelo(int tipoPelo) {
		this.tipoPelo = tipoPelo;
	}
	

}
