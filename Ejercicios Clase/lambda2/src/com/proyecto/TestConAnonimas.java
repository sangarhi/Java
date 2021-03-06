/**
 * 
 */
package com.proyecto;

import com.proyecto.interfaces.ITest;
import com.proyecto.ln.Validar;
import com.proyecto.ln.Validar2;
import com.proyecto.ln.Validar3;

/**
 * @author Luis Antonio L?pez
 *
 */
public class TestConAnonimas {
	
	public static void main(String[] args) {
		
		ITest variable1 = new ITest() {
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
		};
		ITest variable2 = new ITest() {
			@Override
			public boolean test(Object objeto) {
				Integer numero = (Integer)objeto;	
				return ((numero == null) || numero==0);
			}
		};
		ITest variable3 = new ITest() {
			@Override
			public boolean test(Object objeto) {	
				return (objeto == null);
			}
		};
		
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
