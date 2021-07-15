package com.exceptions;

import java.util.Scanner;

import com.exceptions.common.exception.NotAllowedWordsException;
import com.exceptions.common.exception.StringNotValidException;
import com.exceptions.common.exception.StringTooLongException;
import com.exceptions.common.exception.StringTooShortException;
import com.exceptions.common.util.ValidationString;

public class Test {

	// Todo el código excepto las declaraciones debe estar en un bloque try-catch
	public static void main(String[] args) throws StringNotValidException {
		// Declarar las variables necesarias		
		String cadena;
		
		try(Scanner sc= new Scanner(System.in)) {
			
			// Paso 1. Realizar un bucle infinito, que únicamente se pare
			// cuando el código lance una excepcion de cadena nula o vacía o 
			// de palabra no permitida introducida
			while(true) {
				// Paso 2. Pedir una cadena por consola al usuario
				System.out.println("Por favor intruzca cadena");
				 cadena = sc.nextLine();
				
				// Paso 3. Validar si la cadena es correcta con los valores por defecto
				// Si no es correcta mostrar al usuario el mensaje adecuado por cada caso
				
					try {
						ValidationString.validLenght(cadena);
						
						// Paso 4. Se muestra un mensaje de cadena válida
						System.out.println("Felicidades¡ La cadena es válida");
						
						
					} catch (StringTooLongException stle) {
						System.out.println("Cadena demasiado larga");
					}catch (StringTooShortException stse) {
						System.out.println("Cadena demasiado corta");
					}						
				
			}
		}catch(NotAllowedWordsException nawe) {
			System.out.println(nawe.getMessage());
		    
		}catch(StringNotValidException snv) {
			System.out.println(snv.getMessage());
		    throw snv;
		}catch(Exception e) {
			System.out.println("Excepcion general");
		}


	}

}
