package com.lambda.paso3;

import com.lambda.paso2.Calculadora;
import com.lambda.paso2.ICalculadora;

public class TestPaso3 {

	public static void main(String[] args) {
		ICalculadora calculadora = new Calculadora(){
			 public double operacion(double operando1, double operando2){
		          return operando1+operando2;
			  }

		};
		double operando1 = 4;
		double operando2= 3;
		double resultado = operacion(operando1, operando2,calculadora);
		System.out.println("Resultado:"+ resultado);

	}
	private static double operacion(double operando1,double operando2, ICalculadora calculadora) {
		return calculadora.operacion(operando1, operando2);
	}

}
