package com.herencia.ln;

import com.herencia.data.Serpiente;
import com.herencia.ln.interfaces.ISerpiente;

public class GesSerpiente implements ISerpiente {
	
	Serpiente serpiente;

	@Override
	public void comer() {
		System.out.println("Serpiente-comer");

	}

	@Override
	public void nacer() {

		System.out.println("Serpiente-nacer");

	}

	@Override
	public void vivir() {

		System.out.println("Serpiente-vivir");

	}

	@Override
	public void morir() {

		System.out.println("Serpiente-morir");

	}

	@Override
	public void reptar() {

		System.out.println("Serpiente-reptar");

	}

}
