package com.ejercicio.data;

import java.util.List;

public class Inmobiliaria {
	
	private static Inmobiliaria inmobiliaria;
	
	private List<Casa> inmuebles;
	
	
	private Inmobiliaria() {
		
	}
	
	public static Inmobiliaria getInmobiliaria() {
		if(inmobiliaria==null) inmobiliaria= new Inmobiliaria();
		return inmobiliaria;
	}

	public List<Casa> getInmuebles() {
		return inmuebles;
	}

	public void setInmuebles(List<Casa> inmuebles) {
		this.inmuebles = inmuebles;
	}
	
	
	
	
	

}
