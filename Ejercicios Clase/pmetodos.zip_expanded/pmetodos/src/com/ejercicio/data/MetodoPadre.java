
package com.ejercicio.data;

public abstract class MetodoPadre {
	// Paso 1: Crear un metodo privado llamado "metodoEstatico" que tenga como
	// par�metro una cadena
	// mostrar� un syso con la concatenaci�n de la cadena y "Metodo Padre"
	private static void metodoEstatico(String cadena) {
		System.out.println(cadena + "Metodo padre");
	}

	// Paso 2: Crear un metodo protegido llamado "metodoPadre" sin par�metros
	// que devuelva "Metodo Padre"
	protected String metodoPadre() {
		return "Metodo Padre";
	}

	// Paso 3: Sobrecargar el metodo anterior pasando una cadena
	// que muestre por consola la cadena de invocar al metodo anterior
	// y que devuelva la concatenaci�n de la cadena(palabra) y lo que devuelva
	// el metodo padre sin parametros
	protected String metodoPadre(String cadena) {
		System.out.println(metodoPadre());
		return cadena + metodoPadre();
	}

	// Paso 4: Crear un metodo protegido y final llamado "metodoPadre2" sin
	// par�metros
	// que invoque al m�todo est�tico de esta clase con una cadena cualquiera.
	protected final void metodoPadre2() {
		metodoEstatico("Hola");
	}

	// Paso 5: Crear un metodo abstracto metodoPadre2, que tenga como parametro una
	// cadena
	public abstract void metodoPadre2(String cadena);

	// Paso 6: Crear un metodo abstracto metodoPadre2, que tenga como parametro una
	// cadena y un entero primitivo
	public abstract void metodoPadre2(String cadena, int numero);

}
