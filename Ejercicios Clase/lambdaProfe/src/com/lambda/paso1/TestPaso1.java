package com.lambda.paso1;

public class TestPaso1 {

	public static void main(String[] args) {
		Calculadora calculadora = new Calculadora();
		double operando1 = 4;
		double operando2= 3;
		double resultado = operacion(operando1, operando2,calculadora);
		System.out.println("Resultado:"+ resultado);

	}
	private static double operacion(double operando1,double operando2, Calculadora calculadora) {
		return calculadora.operacion(operando1, operando2);
	}

}
