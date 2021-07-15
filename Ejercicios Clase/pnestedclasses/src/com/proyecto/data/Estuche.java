package com.proyecto.data;

import java.util.ArrayList;

public class Estuche {
	// Paso 1. Crear un atributo privado "lapices" de tipo lista de Lapiz, no se
	// permite el SET
	private ArrayList<Lapiz> lapices;

	// Paso 2. Crear el constructor por defecto inicializando el atributo
	public Estuche() {
		super();
		this.lapices = new ArrayList<Lapiz>();
	}

	public ArrayList<Lapiz> getLapices() {
		return lapices;
	}

	// Paso 3.Crear una clase publica y estática Nino con un atributo privado
	// nombre.
	// Paso 4.Implementando un singleton
	public static class Nino {

		private static Nino instancia;
		private String nombre;

		private Nino(String nombre) {
			this.nombre = nombre;
		}

		public static Nino getNinoInstance(String nombre) {
			if (instancia == null) {
				instancia = new Nino(nombre);
			}

			return instancia;
		}
	}

	// Paso 5. Crear una clase publica anidada Lapiz
	public class Lapiz {

		// Paso 6. Crear el contructor por defecto que añada la instancia al listado
		public Lapiz() {
			lapices.add(this);
		}

		// Paso 7. Crear un método pinta que muestre por pantalla:"El lapiz escribe en
		// gris y se puede borrar"
		public void pinta() {
			System.out.println("El lapiz escribe gris y se puede borrar");
		}

	}

	// Paso 8. Crear un clase anidada Pintura que extienda de Lapiz
	public class Pintura extends Lapiz {
		// Paso 9. Crear un método pinta que muestre por pantalla:"La pintura escribe en
		// diferentes colores"
		public void pinta() {
			System.out.println("El boli pinta en azul");
		}
	}

	// Paso 10. Crear un clase anidada Boli que extienda de Lapiz
	public class Boli extends Lapiz {
		// Paso 11. Crear un método pinta que muestre por pantalla:"La pintura escribe
		// en diferentes colores"
		public void pinta() {
			System.out.println("La pintura escribe en diferentes colores");
		}
	}

}
