/**
 * 
 */
package com.proyecto.ln;

import com.proyecto.interfaces.ITest;

/**
 * @author Luis Antonio L�pez
 *
 */
public class Validar2 implements ITest {
	
	@Override
	public boolean test(Object objeto) {
		Integer numero = (Integer)objeto;	
		return ((numero == null) || numero==0);
	}


}
