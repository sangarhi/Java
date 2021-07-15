/**
 * 
 */
package com.proyecto.ln;

import com.proyecto.interfaces.ITest;

/**
 * @author Luis Antonio López
 *
 */
public class Validar implements ITest {

	@Override
	public boolean test(Object objeto) {
		String cadena = (String)objeto;
	/*	boolean resultado = false;
		if (cadena == null || cadena.isEmpty()) {
			resultado = true;
		} 
		return resultado;*/		
		return ((cadena == null) || cadena.isEmpty());
	}


}
