package com.herencia.data;

//ESTA CLASE NO SE PUEDE HEREDAR
public final class Dalmata extends Perro {

	//En las clases FINALES los atributos siempre son privados. 
	private int tipoMoteado;

	public Dalmata() {
		
	}

	public int getTipoMoteado() {
		return tipoMoteado;
	}

	public void setTipoMoteado(int tipoMoteado) {
		this.tipoMoteado = tipoMoteado;
	}
	
	
}
