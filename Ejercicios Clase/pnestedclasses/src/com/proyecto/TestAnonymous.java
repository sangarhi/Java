package com.proyecto;

import com.proyecto.data.Conducir;
import com.proyecto.interfaces.IConducir;

public class TestAnonymous {

	public static void main(String[] args) {

		// Paso 1. Crear una clase Conducir e instanciarla
		Conducir conducir = new Conducir();
		// Paso 2. Invocar a un método conducir sin parámetros y sin retorno que muestre
		// un syso
		conducir.conducir();
		// Paso 3. Indicar una variable de tipo Conducir que se instancie a través de
		// una
		// clase anónima que sobreescriba el metodo conducir.
		Conducir conducir2 = new Conducir() {
			@Override
			public void conducir() {
				System.out.println("Conduce la clase anónima");
			}
		};

		// Paso4. Invcar al método conducir sobreescrito
		conducir2.conducir();
		// Paso 5. Generar una interfaz funcional IConducir con la clase conducir
		IConducir conducir3 = new Conducir();
		conducir3.conducir();
		// Paso 6. Indicar una variable de tipo IConducir que se instancie a través de
		// una clase anónima que sobreescriba el metodo conducir, utilizando la clase
		// Conducir
		IConducir conducir4 = new Conducir() {
			@Override
			public void conducir() {
				System.out.println("Otra vez por la clase anónima (Interfaz)");
			}
		};
		// Paso 7. Invocar al método conducir
		conducir4.conducir();
		// Paso 8. Indicar una variable de tipo IConducir que se instancie a través de
		// una  clase anónima que sobreescriba el metodo conducir, utilizando la interfaz
		// IConducir
		IConducir conducir5 = new IConducir() {
			
			public void conducir() {
				System.out.println("Conduciendo por la clase anónima que le da contenido/cuerpo "
						+ "a lo que está definido en la interfaz");
				
			}
		};
		// Paso 9. Invocar al método conducir
		conducir5.conducir();
	}
	
	
}
