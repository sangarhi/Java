package com.exceptions.common.util;

import com.exceptions.common.Constantes;
import com.exceptions.common.NotAllowedWord;
import com.exceptions.common.exception.CodeErrors;
import com.exceptions.common.exception.NotAllowedWordsException;
import com.exceptions.common.exception.StringNotValidException;
import com.exceptions.common.exception.StringTooLongException;

public class ValidationString {

	// Paso 1. Implementar un método estático "validLenght"que valide
	// si una cadena tiene mas tamañano de 25 posiciones y menos de 1 posición
	// El método tiene que devolver void, utilizar excepciones, declarar las
	// necesarias
	public static void validLenght(String cadena) throws StringNotValidException {
		// Paso 1.1. Validar si la cadena no es nula y no esta vacía
		stringNotNullEmpty(cadena);
		// Paso 1.2 Validar si es mayor que el tamaño maximo (Constantes)
		if(cadena.length() > Constantes.TAMANIO_MAX)
			throw new StringTooLongException(CodeErrors.STRING_TOO_LONG, Constantes.TAMANIO_MAX, "");
		// Paso 1.3 Validar si es menor que el tamaño minimo (Constantes)
		if(cadena.length() < Constantes.TAMANIO_MIN)
			throw new StringTooLongException(CodeErrors.STRING_TOO_SHORT, Constantes.TAMANIO_MIN, "");
		
		// Paso 1.4 Validar si no contiene palabras no permitidas;
		stringNotContainsWordNotAllowed(cadena);	  
 
	}

	

	// Paso 2: Sobrecargar el método anterior para que realize las
	// validaciones con dos valores máximo y mínimo pasados por parámetros
	
	public static void validLenght(String cadena,int valorMaximo,int valorMinimo) throws StringNotValidException {
		// Paso 1.1. Validar si la cadena no es nula y no esta vacía
		stringNotNullEmpty(cadena);
		// Paso 1.2 Validar si es mayor que el tamaño maximo (Constantes)
		if(cadena.length() > valorMaximo)
			throw new StringTooLongException(CodeErrors.STRING_TOO_LONG, valorMaximo, "");
		// Paso 1.3 Validar si es menor que el tamaño minimo (Constantes)
		if(cadena.length() < valorMinimo)
			throw new StringTooLongException(CodeErrors.STRING_TOO_SHORT, valorMinimo, "");
		
		stringNotContainsWordNotAllowed(cadena);	  
 
	}
	

	// Paso 3. Si alguna funcionalidad se repitiese extraerla en un método privado
	
	private static void stringNotNullEmpty(String cadena) throws StringNotValidException {
		if (cadena == null || cadena.isEmpty())
			throw new StringNotValidException(CodeErrors.NO_STRING, "");
	}
	
	private static void stringNotContainsWordNotAllowed(String cadena) throws NotAllowedWordsException {
		for(NotAllowedWord word: NotAllowedWord.values()) {
			if(cadena.contains(word.toString())) {
				NotAllowedWordsException e = new NotAllowedWordsException(CodeErrors.WORD_NOT_ALLOWED_FOUND, word, "");
				throw e;
			}
		}
	}

}
