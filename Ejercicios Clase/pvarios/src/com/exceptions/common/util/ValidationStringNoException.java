package com.exceptions.common.util;

import com.exceptions.common.Constantes;
import com.exceptions.common.NotAllowedWord;

public class ValidationStringNoException {

	// Paso 1. Implementar un método estático "validLenght"que valide
	// los mismos puntos que el método ValidationString.validLenght
	// El método tiene que devolver boolean


	// Paso 1.2 Validar si es mayor que el tamaño maximo (Constantes)
	public static boolean stringMaxLength(String cadena) {
		if (cadena.length() > Constantes.TAMANIO_MAX) {
			return Boolean.FALSE;
		}
			
		return Boolean.TRUE;
	}

	// Paso 1.3 Validar si es menor que el tamaño minimo (Constantes)
	public static boolean stringMinLength(String cadena) {
		if (cadena.length() < Constantes.TAMANIO_MIN) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	// Paso 1.1. Validar si la cadena no es nula y no esta vacía
	public static boolean stringNotNullEmpty(String cadena) {
		if (cadena == null || cadena.isEmpty())
			return Boolean.FALSE;
		return Boolean.TRUE;
	}

	// Paso 1.4 Validar si no contiene palabras no permitidas;
	public static boolean stringNotContainsWordNotAllowed(String cadena) {
		for (NotAllowedWord word : NotAllowedWord.values()) {
			if (cadena.toUpperCase().contains(word.toString())) {
				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}

}
