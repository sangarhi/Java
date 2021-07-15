package com.herencia.ln.interfaces;

public interface IOso extends IMamifero, IOmnivoro {
	
	//EStoy SOBRECARGANDO el método comer de la interfaz Omnivoro
	public void comer(int tipoComida);
}
