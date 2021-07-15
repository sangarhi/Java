package com.lambda.paso6;

import java.util.ArrayList;

public class TestPaso6 {

	public static void main(String[] args) {
		
		double operando1 = 4;
		
		double operando2= 3;
		
		
		
		ArrayList<ICalculadora> funciones = new ArrayList<ICalculadora>();
		
		ICalculadora calculadora = (a,b)-> {
			double x = 0;
			x = a + b;
			x /=  3;
			return x;
		};
		
		funciones.add(calculadora);
		
		ICalculadora calculadora2 = (a,b)-> {
			double x = 0;
			x = a + b;
			return x;
		};
		
		funciones.add(calculadora2);
		
		
		for(ICalculadora calculo : funciones)
			System.out.println("Resultado:"+ calculo.nosequehacer(operando1, operando2));
		
		

	}
	
	
	private static double operacion(double operando1,double operando2, ICalculadora calculadora) {
		return calculadora.nosequehacer(operando1, operando2);
	}
	
	

}

@FunctionalInterface 
interface ICalculadora {
	public double nosequehacer(double operando1, double operando2);
}
