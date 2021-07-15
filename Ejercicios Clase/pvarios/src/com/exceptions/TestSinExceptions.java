package com.exceptions;

import java.util.Scanner;

import com.exceptions.common.exception.NotAllowedWordsException;
import com.exceptions.common.exception.StringNotValidException;
import com.exceptions.common.exception.StringTooLongException;
import com.exceptions.common.exception.StringTooShortException;
import com.exceptions.common.util.ValidationString;
import com.exceptions.common.util.ValidationStringNoException;

public class TestSinExceptions {

	public static void main(String[] args) throws StringNotValidException {
		// Declarar las variables necesarias
		String cadena;
		boolean isValid = Boolean.TRUE;

		Scanner sc = new Scanner(System.in);

		// Paso 1. Realizar un bucle infinito, que únicamente se pare
		// cuando la cadena sea vacia o contenga una palabra no permitida
		while (isValid) {
			// Paso 2. Pedir una cadena por consola al usuario
			System.out.println("Por favor introduzca cadena");
			cadena = sc.nextLine();

			// Paso 3. Validar si la cadena es correcta con los valores por defecto
			// Si no es correcta mostrar al usuario el mensaje adecuado por cada caso
			if (!ValidationStringNoException.stringNotNullEmpty(cadena)) {
				System.out.println("Cadena nula o vacía");
				isValid = Boolean.FALSE;
			} else if (!ValidationStringNoException.stringNotContainsWordNotAllowed(cadena)) {
				System.out.println("Palabra no permitida");
				isValid = Boolean.FALSE;
			} else if (!ValidationStringNoException.stringMaxLength(cadena))
				System.out.println("Cadena demasiado larga");
			else if (!ValidationStringNoException.stringMinLength(cadena))
				System.out.println("Cadena demasiado corta");
			else
				System.out.println("Enhorabuena, esa palabra es válida");

		}
		System.out.println("Fin del programa");
		sc.close();
	}

}
