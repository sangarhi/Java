package com.tipoLambda.ln;

import com.tipoLambda.interfaces.IConsumidora;

public class Consumidora implements IConsumidora {

	@Override
	public void accept(String cadena) {
		System.out.println(cadena);

	}

}
