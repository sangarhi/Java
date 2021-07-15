package com.javabasico.base;
/**
 * Calculadora, se realizan las operaciones básicas mediante metodos estáticos
 * @author MARIA
 *
 */
public class Calculadora {
	/**
	 * Suma
	 * @param operando1
	 * @param operando2
	 */
	public static void suma(int operando1,int operando2) {
		int suma = operando1+operando2;
		//Se utiliza la constante suma
		System.out.println(Constantes.SUMA+suma);
	}

	/**
	 * Resta
	 * @param operando1
	 * @param operando2
	 */
	public static void resta(int operando1,int operando2) {
		int resta = operando1+operando2;
		System.out.println("Resta:"+resta);
	}

	/**
	 * Multiplicacion
	 * @param operando1
	 * @param operando2
	 */
	public static void multiplicacion(int operando1,int operando2) {
		long multiplicacion = operando1+operando2;
		System.out.println("Multiplicacion:"+multiplicacion);
	}

	/**
	 * Division
	 * @param operando1
	 * @param operando2
	 */
	public static void division(int operando1,int operando2) {
		double division = operando1/operando2;
		System.out.println("Division:"+division);
	}
	

}
