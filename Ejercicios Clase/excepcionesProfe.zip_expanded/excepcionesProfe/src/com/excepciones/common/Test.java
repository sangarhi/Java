package com.excepciones.common;

public class Test {
	TipoExcepcion tipo;

	/*
	 * public static void main(String[] args) {
	 * 
	 * //EJEMPLO DE MAIN SIN GESTIONAR EXCEPCIONES Test test = new Test();
	 * test.tipo.getDescripcion();
	 * 
	 * System.out.println("Aqui no llego"); System.out.println(test.tipo);
	 * 
	 * 
	 * }
	 */

	public static void main(String[] args) {
		// EJEMPLO DE MAIN CON GESTION EXCEPCIONES
		Test test = new Test();
		;

		try {
			// test = new Test();
			// test.tipo.getDescripcion();

			System.out.println("Aqui no llego");
			System.out.println(test.tipo);

		} catch (RuntimeException re) {
			System.out.println("Se ha generado RuntimeException:");
			re.printStackTrace();
		} catch (Exception e) {

			String mensaje = e.getMessage();
			System.out.println("Se ha generado excepción");
		} finally {
			System.out.println("Esto se va a ejecutar si o si");
			try {
				test.tipo.getDescripcion();
			} catch (Exception e) {
				System.out.println("Excepcion en el finally");
			}
		}
		System.out.println("Aqui si que llego porque la hemos capturado");

	}

}
