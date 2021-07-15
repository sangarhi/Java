package com.tipoLambda.ln;

import com.tipoLambda.data.Casa;
import com.tipoLambda.interfaces.IFuncion;

public class Funcion implements IFuncion {

	@Override
	public Integer apply(Casa casa) {
		
		return casa.getNumHabitaciones();
	}

}
