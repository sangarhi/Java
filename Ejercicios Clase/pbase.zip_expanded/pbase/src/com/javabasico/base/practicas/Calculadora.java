package com.javabasico.base.practicas;
/**
 * Calculadora, se realizan las operaciones básicas mediante metodos estáticos
 * @author MARIA
 *
 */
public class Calculadora {
	//Añadir las constantes para que no existan cadenas en los sysos
	/**
	 * Suma
	 * @param operando1
	 * @param operando2
	 */
	public static void suma(int operando1,int operando2) {
		int suma = operando1+operando2;
		System.out.println(Constantes.SUMA+suma);
	}

	/**
	 * Resta
	 * @param operando1
	 * @param operando2
	 */
	public static void resta(int operando1,int operando2) {
		int resta = operando1-operando2;
		System.out.println(Constantes.RESTA+resta);
	}

	/**
	 * Multiplicacion
	 * @param operando1
	 * @param operando2
	 */
	public static void multiplicacion(int operando1,int operando2) {
		long multiplicacion = operando1*operando2;
		System.out.println(Constantes.MULTIPLICACION+multiplicacion);
	}

	/**
	 * Division
	 * @param operando1
	 * @param operando2
	 */
	public static void division(int operando1,int operando2) {
		double division = operando1/operando2;
		System.out.println(Constantes.DIVISION+division);
	}
	//Añadir un método no estático que realize la suma
	public void suma (Integer operando1,Integer operando2) {
		Integer suma = operando1+operando2;
		System.out.println(Constantes.SUMA+suma);
	}

}
