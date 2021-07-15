package com.proyecto;

import com.proyecto.data.Estuche;
import com.proyecto.data.Estuche.Lapiz;
import com.proyecto.data.Estuche.Nino;

public class Test {

	public static void main(String[] args) {
		// Paso1. Crear una instancia de estuche
		Estuche estuche = new Estuche();

		// MANEJO CLASE ESTÁTICA

		// Paso2.Crear una instancia de niño
		Nino nino = Nino.getNinoInstance("Pepe");
		// Paso3.Crear otra instancia de niño
		Nino nino2 = Nino.getNinoInstance("Adrián");

		// Paso4.Comprobar que es la misma instancia
		if(nino == nino2) System.out.println("Son el mismo objeto");
		if(nino.equals(nino2)) System.out.println("Lo mismo");
		//System.out.println(nino);
		//System.out.println(nino2);

		// MANEJO CLASES INTERNAS

		// Paso 5. Crear una instancia de lapiz
		Estuche.Lapiz lapiz = estuche.new Lapiz();

		// Paso 6.Crear una instancia de pintura
		Estuche.Lapiz pintura = estuche.new Pintura();

		// Paso 7.Crear una instancia de boli
		Estuche.Lapiz boli = estuche.new Boli();

		// Paso 7.Crear otra instancia de boli
		Estuche.Lapiz boli2 = estuche.new Boli();

		// Paso 8. Ejecutar pinta para todos los objetos tipo Lapiz
		// que tenga estuche y mostrar un syso con el objeto
		for (Lapiz lapizAux : estuche.getLapices()) {
			System.out.println("Objeto: " + lapizAux);
			lapizAux.pinta();
		}
		//

	}

}
