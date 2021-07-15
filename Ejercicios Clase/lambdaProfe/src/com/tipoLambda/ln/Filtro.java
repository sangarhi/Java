package com.tipoLambda.ln;

import com.tipoLambda.interfaces.IFiltro;

public class Filtro implements IFiltro {

	@Override
	public boolean test(Object o) {
		//Comprobamos  si la cadena es nula o vacía
		return (o==null || ((String)o).length()==0);
	}

}
