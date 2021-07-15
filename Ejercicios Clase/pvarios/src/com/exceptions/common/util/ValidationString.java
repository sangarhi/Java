package com.exceptions.common.util;

import com.exceptions.common.Constantes;
import com.exceptions.common.NotAllowedWord;
import com.exceptions.common.exception.CodeErrors;
import com.exceptions.common.exception.NotAllowedWordsException;
import com.exceptions.common.exception.StringNotValidException;
import com.exceptions.common.exception.StringTooLongException;

public class ValidationString {

	// Paso 1. Implementar un m�todo est�tico "validLenght"que valide
	// si una cadena tiene mas tama�ano de 25 posiciones y menos de 1 posici�n
	// El m�todo tiene que devolver void, utilizar excepciones, declarar las
	// necesarias
	public static void validLenght(String cadena) throws StringNotValidException {
		// Paso 1.1. Validar si la cadena no es nula y no esta vac�a
		stringNotNullEmpty(cadena);
		// Paso 1.2 Validar si es mayor que el tama�o maximo (Constantes)
		if(cadena.length() > Constantes.TAMANIO_MAX)
			throw new StringTooLongException(CodeErrors.STRING_TOO_LONG, Constantes.TAMANIO_MAX, "");
		// Paso 1.3 Validar si es menor que el tama�o minimo (Constantes)
		if(cadena.length() < Constantes.TAMANIO_MIN)
			throw new StringTooLongException(CodeErrors.STRING_TOO_SHORT, Constantes.TAMANIO_MIN, "");
		
		// Paso 1.4 Validar si no contiene palabras no permitidas;
		stringNotContainsWordNotAllowed(cadena);	  
 
	}

	

	// Paso 2: Sobrecargar el m�todo anterior para que realize las
	// validaciones con dos valores m�ximo y m�nimo pasados por par�metros
	
	public static void validLenght(String cadena,int valorMaximo,int valorMinimo) throws StringNotValidException {
		// Paso 1.1. Validar si la cadena no es nula y no esta vac�a
		stringNotNullEmpty(cadena);
		// Paso 1.2 Validar si es mayor que el tama�o maximo (Constantes)
		if(cadena.length() > valorMaximo)
			throw new StringTooLongException(CodeErrors.STRING_TOO_LONG, valorMaximo, "");
		// Paso 1.3 Validar si es menor que el tama�o minimo (Constantes)
		if(cadena.length() < valorMinimo)
			throw new StringTooLongException(CodeErrors.STRING_TOO_SHORT, valorMinimo, "");
		
		stringNotContainsWordNotAllowed(cadena);	  
 
	}
	

	// Paso 3. Si alguna funcionalidad se repitiese extraerla en un m�todo privado
	
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
