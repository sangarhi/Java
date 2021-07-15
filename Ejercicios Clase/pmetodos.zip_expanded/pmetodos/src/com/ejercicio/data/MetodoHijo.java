package com.ejercicio.data;

public class MetodoHijo extends Metodo {

	// Paso 1: Crear un metodo publico llamado "metodoEstatico" que tenga como
	// parámetro una cadena
	// mostrará un syso con la concatenación de "Metodo Estático Hijjo" y de la cadena
	// El método devolverá esta concatenación.
	
	public static String metodoEstatico(String cadena) {
		String concatenacion = "Método Estático Hijo " + cadena;
		System.out.println(concatenacion);
		
		return concatenacion;
	}
	
	// Paso 2: Implementar todos los métodos necesarios para que sea una clase concreta
	// Si tienen parametros que se concatenen con la cadena "Hijo"
	// y si devuelven algo que devuelvan ese resultado, si no devuelven nada
	// que lo muestren por pantalla
	// Hay que indicar mediante un syso, en qué clase esta la definición del método
	
	@Override
	public String metodoPadre(String cadena, Integer numero) {
		String concatenacion = "Hijo" + cadena + numero;
		System.out.println("Se encuentra en IMetodo");
		return concatenacion;
	}

	@Override
	public void metodoPadre2(String cadena, Integer numero) {
		String concatenacion = "Hijo" + cadena + numero;
		//cadena = cadena.concat(String.valueOf(entero)).concat("Hijo);
		//cadena = cadena.concat(entero.toString()).concat("Hijo);
		System.out.println(concatenacion);
		System.out.println("Se encuentra en Metodo");
		
	}

	@Override
	public void metodoPadre2(String cadena) {
		String concatenacion = "Hijo" + cadena;
		System.out.println(concatenacion);
		System.out.println("Se encuentra en MetodoPadre");
		
	}

	@Override
	public void metodoPadre2(String cadena, int numero) {
		String concatenacion = "Hijo" + cadena + numero;
		System.out.println(concatenacion);
		System.out.println("Se encuentra en MetodoPadre");
		
	}

	// Paso 3: Sobreescribir el metodo "metodo" sin parametros invocando
	// que invoque al método estático de esta clase con una cadena cualquiera.
	// Devolverá el resultado del método estatico y con la suma de " Metodo Sin
	// parametros";
	
	@Override
	public String metodo() {
		String cadenaMetodo = metodoEstatico("Invocando");
		return cadenaMetodo + "Método sin parámetros: ";
	}
	

}
