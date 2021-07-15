package com.ejercicio.data;

public abstract  class Metodo extends MetodoPadre implements IMetodo{

	//Paso 1: Crear un metodo privado llamado "metodoEstatico" que tenga como par�metro una cadena
	// mostrar� un syso con la concatenaci�n de "Metodo Est�tico" y de la cadena
	// El m�todo devolver� esta concatenaci�n.
	
	private static String metodoEstatico(String cadena) {
		cadena += " Metodo est�tico";
		System.out.println(cadena);
		
		return cadena;
	}
	
	//Paso 2: Implementar el m�todo "metodo" invocando
	//que invoque al m�todo est�tico de esta clase con una cadena cualquiera.
	//Devolver� el resultado del m�todo estatico y con la suma de " Metodo Sin parametros";
	
	@Override
	public String metodo(String cadena) {
		String cadenaMetodo = metodoEstatico("Invocando");
		return "M�todo sin par�metros: " + cadenaMetodo;
	}
	//Paso 3: Sobreescribir el metodo que se pueda sin parametros haciendolo publico
	//Devolvera la cadena "Metodo
	
	@Override
	public String metodo() {
		return "Metodo";
	}
	
	@Override
	public String metodoPadre() {
		return "Metodo";
	}
		
	//Paso 2: �Poqu� no compila? 
	//Sin implementar m�todos nuevos arreglar el fallo de compilacion
	
	//A�adiendo a la clase que sea abstract

	//Paso 3: Crear un metodo abstracto metodoPadre2, que tenga como parametro una cadena y un objeto entero
	
	public abstract void metodoPadre2(String cadena, Integer numero);

}
