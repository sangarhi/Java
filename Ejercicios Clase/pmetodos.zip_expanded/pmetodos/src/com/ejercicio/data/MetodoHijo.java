package com.ejercicio.data;

public class MetodoHijo extends Metodo {

	// Paso 1: Crear un metodo publico llamado "metodoEstatico" que tenga como
	// par�metro una cadena
	// mostrar� un syso con la concatenaci�n de "Metodo Est�tico Hijjo" y de la cadena
	// El m�todo devolver� esta concatenaci�n.
	
	public static String metodoEstatico(String cadena) {
		String concatenacion = "M�todo Est�tico Hijo " + cadena;
		System.out.println(concatenacion);
		
		return concatenacion;
	}
	
	// Paso 2: Implementar todos los m�todos necesarios para que sea una clase concreta
	// Si tienen parametros que se concatenen con la cadena "Hijo"
	// y si devuelven algo que devuelvan ese resultado, si no devuelven nada
	// que lo muestren por pantalla
	// Hay que indicar mediante un syso, en qu� clase esta la definici�n del m�todo
	
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
	// que invoque al m�todo est�tico de esta clase con una cadena cualquiera.
	// Devolver� el resultado del m�todo estatico y con la suma de " Metodo Sin
	// parametros";
	
	@Override
	public String metodo() {
		String cadenaMetodo = metodoEstatico("Invocando");
		return cadenaMetodo + "M�todo sin par�metros: ";
	}
	

}
