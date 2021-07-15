/**
 * 
 */
package com.proyecto;

import com.proyecto.interfaces.ITest;
import com.proyecto.ln.Validar;
import com.proyecto.ln.Validar2;
import com.proyecto.ln.Validar3;

/**
 * @author Luis Antonio López
 *
 */
public class TestSinLambdas {
	
	public static void main(String[] args) {
		
		ITest variable1 = new Validar(); 
		ITest variable2 = new Validar2();
		ITest variable3 = new Validar3();
		
		boolean resultado1 = comprobar("Hola", variable1);
		System.out.println("El resultado1 es " + resultado1);
		
		boolean resultado2 = comprobar(3, variable2);
		System.out.println("El resultado2 es " + resultado2);
		
		boolean resultado3 = comprobar(null, variable3);
		System.out.println("El resultado3 es " + resultado3);
	}
	
	private static boolean comprobar(Object objeto, ITest it) {
		return it.test(objeto);
	}

}
