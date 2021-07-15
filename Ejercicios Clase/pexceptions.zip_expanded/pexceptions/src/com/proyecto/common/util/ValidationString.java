package com.proyecto.common.util;

import com.proyecto.common.Constantes;
import com.proyecto.common.NotAllowedWord;
import com.proyecto.common.exception.CodeErrors;
import com.proyecto.common.exception.NotAllowedWordsException;
import com.proyecto.common.exception.StringNotValidException;
import com.proyecto.common.exception.StringTooLongException;
import com.proyecto.common.exception.StringTooShortException;

public class ValidationString {

	// Paso 1. Implementar un método estático "validLenght"que valide
	// si una cadena tiene mas tamañano de 25 posiciones y menos de 1 posición
	// El método tiene que devolver void, utilizar excepciones, declarar las
	// necesarias
	public static void validLength(String cadena) throws StringNotValidException {
		// Paso 1.1 Validar si la cadena no es nula o vacía
		stringNotNullEmpty(cadena);
		// Paso 1.2 Validar si es mayor que el tamaño maximo (Constantes)
		if (cadena.length() > Constantes.TAMANIO_MAX)
			throw new StringTooLongException(CodeErrors.STRING_TOO_LONG, "", Constantes.TAMANIO_MAX);
		// Paso 1.3 Validar si es menor que el tamaño minimo (Constantes)
		if (cadena.length() < Constantes.TAMANIO_MIN)
			throw new StringTooShortException(CodeErrors.STRING_TOO_SHORT, "", Constantes.TAMANIO_MIN);
		// Paso 1.4 Validar si no contiene palabras no permitidas;
		stringNotContainsWordNotAllowed(cadena);
	}

	// Paso 2: Sobrecargar el método anterior para que realize las
	// validaciones con dos valores máximo y mínimo pasados por parámetros
	public static void validLength(int max, int min, String cadena) throws StringNotValidException {
		stringNotNullEmpty(cadena);
		if (cadena.length() > max)
			throw new StringTooLongException(CodeErrors.STRING_TOO_LONG, " ", max);
		if (cadena.length() < min)
			throw new StringTooShortException(CodeErrors.STRING_TOO_SHORT, " ", min);
		stringNotContainsWordNotAllowed(cadena);
	}

	// Paso 3. Si alguna funcionalidad se repitiese extraerla en un método privado >   Seleccionar código > Refactor > Extract Methods
	private static void stringNotNullEmpty(String cadena) throws StringNotValidException {
		if (cadena == null || cadena.isEmpty())
			throw new StringNotValidException(CodeErrors.NO_STRING, "NO_STRING");
	}

	private static void stringNotContainsWordNotAllowed(String cadena) throws NotAllowedWordsException {
		for (NotAllowedWord word : NotAllowedWord.values()) {
			if (cadena.equalsIgnoreCase(word.toString())) // En el ejemplo de clase, está con cadena.contains (pero a mi este me funciona)
				throw new NotAllowedWordsException(CodeErrors.WORD_NOT_ALLOWED_FOUND, "", word);
		}
	}

}
