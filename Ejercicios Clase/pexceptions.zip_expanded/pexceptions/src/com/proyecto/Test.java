package com.proyecto;

import java.util.Scanner;

import com.proyecto.common.exception.NotAllowedWordsException;
import com.proyecto.common.exception.StringNotValidException;
import com.proyecto.common.exception.StringTooLongException;
import com.proyecto.common.exception.StringTooShortException;
import com.proyecto.common.util.ValidationString;

public class Test {

	// Todo el código excepto las declaraciones debe estar en un bloque try-catch
	public static void main(String[] args) throws StringNotValidException {
		// Declarar las variables necesarias
		String cadena;

		try (Scanner sc = new Scanner(System.in)) {
			// Paso 1. Realizar un bucle infinito, que únicamente se pare
			// cuando el código lance una excepcion de cadena nula o vacía o
			// de palabra no permitida introducida
			while (true) {
				// Paso 2. Pedir una cadena por consola al usuario
				System.out.println("Por favor introduzca una cadena");
				cadena = sc.nextLine();
				// Paso 3. Validar si la cadena es correcta con los valores por defecto
				// Si no es correcta mostrar al usuario el mensaje adecuado por cada caso
				try {
					ValidationString.validLength(cadena);
					// Paso 4. Se muestra un mensaje de cadena válida
					System.out.println("Felicidades, la cadena es válida");

				} catch (StringTooLongException stle) {
					System.err.println("Cadena demasiado larga");
				} catch (StringTooShortException stse) {
					System.err.println("Cadena demasiado corta");
				}

			}

		} catch (NotAllowedWordsException nawe) {
			System.err.println(nawe.getMessage());
			// throw nawe; -- Si entra aquí, ya luego sale del main
		} catch (StringNotValidException snv) {
			System.err.println(snv.getMessage());
			throw snv;
		} catch (Exception e) {
			System.err.println("Excepcion general");
		}

	}

}
