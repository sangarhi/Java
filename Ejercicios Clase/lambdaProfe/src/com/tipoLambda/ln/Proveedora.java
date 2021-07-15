package com.tipoLambda.ln;

import com.tipoLambda.interfaces.ISupplier;

public class Proveedora implements ISupplier {

	@Override
	public Object get() {
		return new Integer(5);// return "cadena" //return casa
	}

}
