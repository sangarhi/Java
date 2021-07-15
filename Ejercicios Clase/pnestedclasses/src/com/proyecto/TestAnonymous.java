package com.proyecto;

import com.proyecto.data.Conducir;
import com.proyecto.interfaces.IConducir;

public class TestAnonymous {

	public static void main(String[] args) {

		// Paso 1. Crear una clase Conducir e instanciarla
		Conducir conducir = new Conducir();
		// Paso 2. Invocar a un m�todo conducir sin par�metros y sin retorno que muestre
		// un syso
		conducir.conducir();
		// Paso 3. Indicar una variable de tipo Conducir que se instancie a trav�s de
		// una
		// clase an�nima que sobreescriba el metodo conducir.
		Conducir conducir2 = new Conducir() {
			@Override
			public void conducir() {
				System.out.println("Conduce la clase an�nima");
			}
		};

		// Paso4. Invcar al m�todo conducir sobreescrito
		conducir2.conducir();
		// Paso 5. Generar una interfaz funcional IConducir con la clase conducir
		IConducir conducir3 = new Conducir();
		conducir3.conducir();
		// Paso 6. Indicar una variable de tipo IConducir que se instancie a trav�s de
		// una clase an�nima que sobreescriba el metodo conducir, utilizando la clase
		// Conducir
		IConducir conducir4 = new Conducir() {
			@Override
			public void conducir() {
				System.out.println("Otra vez por la clase an�nima (Interfaz)");
			}
		};
		// Paso 7. Invocar al m�todo conducir
		conducir4.conducir();
		// Paso 8. Indicar una variable de tipo IConducir que se instancie a trav�s de
		// una  clase an�nima que sobreescriba el metodo conducir, utilizando la interfaz
		// IConducir
		IConducir conducir5 = new IConducir() {
			
			public void conducir() {
				System.out.println("Conduciendo por la clase an�nima que le da contenido/cuerpo "
						+ "a lo que est� definido en la interfaz");
				
			}
		};
		// Paso 9. Invocar al m�todo conducir
		conducir5.conducir();
	}
	
	
}
