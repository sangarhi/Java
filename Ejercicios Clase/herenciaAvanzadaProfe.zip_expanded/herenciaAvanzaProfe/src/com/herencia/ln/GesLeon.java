package com.herencia.ln;

import com.herencia.data.Leon;
import com.herencia.ln.interfaces.ILeon;

public class GesLeon implements ILeon {
	
	Leon leon;

	@Override
	public void amamantar() {
		System.out.println("Leon-amamantar");

	}

	@Override
	public void nacer() {
		System.out.println("Leon-nacer");

	}

	@Override
	public void vivir() {
		System.out.println("Leon-vivir");

	}

	@Override
	public void morir() {
		System.out.println("Leon-morir");

	}

	@Override
	public void comer() {
		System.out.println("Leon-comer");

	}

	@Override
	public void rugir() {
		System.out.println("Leon-rugir");

	}

}
