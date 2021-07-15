package com.exceptions;

import java.util.Scanner;

import com.exceptions.common.Constantes;
import com.exceptions.common.NotAllowedWord;
import com.exceptions.common.util.Validation;

public class App {

	/*
	 * Recogía una cadena, y hacer cuatro validaciones: 1. que no fuera nula o vacia
	 * 2. que no contenga las palabras prohibidas 3. que no sea más pequeña que la
	 * constante 4. que no sea más grande que la constante si las dos primeras no se
	 * cumplen, el programa termina si las dos ultimas no se cumplen, te piden otra
	 * cadena
	 * 
	 *
	 */
	public static void main(String[] args) {
		String cadena = null;
		Scanner sc = new Scanner(System.in);
		boolean isNula = Boolean.FALSE;
		boolean isContienePalabrasProhibidas = Boolean.FALSE;
		boolean isPequenia = Boolean.FALSE;
		boolean isGrande = Boolean.FALSE;

		boolean continuar = Boolean.TRUE;

		while (continuar) {
			System.out.println("Introducir Cadena:");
			cadena = sc.nextLine();

			isNula = Validation.validarNoNulaONOVacia(cadena);
			isContienePalabrasProhibidas = Validation.validarContienePalabrasProhibidas(cadena);
			isPequenia = Validation.validarPequenia(cadena);
			isGrande = Validation.validarGrande(cadena);
			if (isNula) {
				System.out.println("La cadena es nula");
				continuar = Boolean.FALSE;
			}
			if (isContienePalabrasProhibidas) {
				System.out.println("La cadena contiene ");
				continuar = Boolean.FALSE;
			}
			if (isPequenia)
				System.out.println("La cadena es pequeña");
			if (isGrande)
				System.out.println("La cadena es grande");

			if (!(isNula && isContienePalabrasProhibidas && isPequenia && isGrande))
				System.out.println("La palabra esta validada");

		}
		System.out.println("Fin de programa");

	}

}
