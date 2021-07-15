package com.herencia.ln;

import com.herencia.data.Conejo;
import com.herencia.ln.interfaces.IConejo;

//EJEMPLO DE CLASE DE NEGOCIO impleta los comportamientos sobre un Bean
public class GesConejo implements IConejo{
	
	Conejo conejo;

	@Override
	public void amamantar() {
		System.out.println("Conejo-amamantar");
		
	}

	@Override
	public void nacer() {
		System.out.println("Conejo-nacer");
		
	}

	@Override
	public void vivir() {
		System.out.println("Conejo-vivir");
		
	}

	@Override
	public void morir() {
		System.out.println("Conejo-morir");
		
	}

	@Override
	public void comer() {
		System.out.println("Conejo-comer");
		
	}

	@Override
	public void saltar() {
		System.out.println("Conejo-saltar");
		
	}

}
