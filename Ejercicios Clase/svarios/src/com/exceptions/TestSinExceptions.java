package com.exceptions;

import java.util.Scanner;

import com.exceptions.common.exception.NotAllowedWordsException;
import com.exceptions.common.exception.StringNotValidException;
import com.exceptions.common.exception.StringTooLongException;
import com.exceptions.common.exception.StringTooShortException;
import com.exceptions.common.util.ValidationString;

public class TestSinExceptions {

// Todo el código excepto las declaraciones debe estar en un bloque try-catch
	public static void main(String[] args) throws StringNotValidException {
		// Declarar las variables necesarias		
		String cadena;
		
		Scanner sc= new Scanner(System.in);
			
			// Paso 1. Realizar un bucle infinito, que únicamente se pare
			// cuando la cadena sea vacia o contenga  una palabra no permitida
			while() {
				// Paso 2. Pedir una cadena por consola al usuario
				System.out.println("Por favor intruzca cadena");
				 cadena = sc.nextLine();
				
				// Paso 3. Validar si la cadena es correcta con los valores por defecto
				// Si no es correcta mostrar al usuario el mensaje adecuado por cada caso
				
					
						
						// Paso 4. Se muestra un mensaje de cadena válida
						System.out.println("Felicidades¡ La cadena es válida");
						
			}
		sc.close();
	}

}
