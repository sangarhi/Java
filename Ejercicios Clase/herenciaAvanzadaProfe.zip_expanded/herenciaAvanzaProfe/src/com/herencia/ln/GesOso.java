package com.herencia.ln;

import com.herencia.data.Oso;
import com.herencia.ln.interfaces.IOso;

public class GesOso implements IOso{
	
	Oso oso;

	@Override
	public void amamantar() {
		System.out.println("Oso-amamantar");
		
	}

	@Override
	public void nacer() {
		System.out.println("Oso-nacer");
		
	}

	@Override
	public void vivir() {
		System.out.println("Oso-vivir");
		
	}

	@Override
	public void morir() {
		System.out.println("Oso-morir");
		
	}

	@Override
	public void comer() {
		System.out.println("Oso-comer");
		
	}

	@Override
	public void comer(int tipoComida) {
		System.out.println("Oso-comer(tipoComida)");
		
	}

}
