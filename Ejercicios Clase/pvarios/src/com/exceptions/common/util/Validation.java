package com.exceptions.common.util;

import java.util.Arrays;

import com.exceptions.common.Constantes;
import com.exceptions.common.NotAllowedWord;
import com.exceptions.common.exception.CodeErrors;
import com.exceptions.common.exception.NotAllowedWordsException;
import com.exceptions.common.exception.StringNotValidException;
import com.exceptions.common.exception.StringTooLongException;

public class Validation {


	public static boolean validarPequenia(String cadena) {

		return (cadena.length() < Constantes.TAMANIO_MIN);
	}

	public static boolean validarGrande(String cadena) {

		return (cadena.length() > Constantes.TAMANIO_MAX);
	}

	public static boolean validarContienePalabrasProhibidas(String cadena) {
		for (NotAllowedWord word : NotAllowedWord.values()) {
			if (cadena.contains(word.toString()))
				return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	public static boolean validarNoNulaONOVacia(String cadena) {

		return cadena == null || cadena.isEmpty();
	}

}
