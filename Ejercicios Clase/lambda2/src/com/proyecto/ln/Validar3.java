/**
 * 
 */
package com.proyecto.ln;

import com.proyecto.interfaces.ITest;

/**
 * @author Luis Antonio L�pez
 *
 */
public class Validar3 implements ITest {
	
	@Override
	public boolean test(Object objeto) {	
		return (objeto == null);
	}


}
