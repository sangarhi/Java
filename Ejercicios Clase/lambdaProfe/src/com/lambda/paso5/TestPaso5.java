package com.lambda.paso5;

import com.lambda.paso4.ICalculadora;

public class TestPaso5 {

	public static void main(String[] args) {
		ICalculadora calculadora = (a,b)->a+b;
		double operando1 = 4;
		double operando2= 3;
		double resultado = operacion(operando1, operando2,calculadora);
		System.out.println("Resultado:"+ resultado);

	}
	private static double operacion(double operando1,double operando2, ICalculadora calculadora) {
		return calculadora.operacion(operando1, operando2);
	}



}
