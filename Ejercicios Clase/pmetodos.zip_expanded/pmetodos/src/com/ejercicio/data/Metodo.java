package com.ejercicio.data;

public abstract  class Metodo extends MetodoPadre implements IMetodo{

	//Paso 1: Crear un metodo privado llamado "metodoEstatico" que tenga como parámetro una cadena
	// mostrará un syso con la concatenación de "Metodo Estático" y de la cadena
	// El método devolverá esta concatenación.
	
	private static String metodoEstatico(String cadena) {
		cadena += " Metodo estático";
		System.out.println(cadena);
		
		return cadena;
	}
	
	//Paso 2: Implementar el método "metodo" invocando
	//que invoque al método estático de esta clase con una cadena cualquiera.
	//Devolverá el resultado del método estatico y con la suma de " Metodo Sin parametros";
	
	@Override
	public String metodo(String cadena) {
		String cadenaMetodo = metodoEstatico("Invocando");
		return "Método sin parámetros: " + cadenaMetodo;
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
		
	//Paso 2: ¿Poqué no compila? 
	//Sin implementar métodos nuevos arreglar el fallo de compilacion
	
	//Añadiendo a la clase que sea abstract

	//Paso 3: Crear un metodo abstracto metodoPadre2, que tenga como parametro una cadena y un objeto entero
	
	public abstract void metodoPadre2(String cadena, Integer numero);

}
