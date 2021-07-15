package com.javabasico.base;

//Modelo de clase de negocio

public class GesDepartamentos {
	// Norma 1: no tiene atributos, se consideran variables de clase de diferente
	// tipo
	Departamento departamento;

	// Norma 2: No tiene porqué tener declarados constructores. Normalmente son
	// metodos de inicialización (negocio)

	// Norma 3:Tiene al menos un método de negocio
	// Ejemplo: CRUD (Create ,Read, Update, Delete)

	public Departamento leer(Long id) {

		Departamento departamento;
		// Las dos lineas siguientes desaparecerían y leeriamos de base de datos el
		// elemento
		departamento = new Departamento();
		departamento.setId(id);

		return departamento;

	}

	public void crear(Departamento departamento) {
		// Almacenariamos los valores del departamento en la base de datos de un
		// departamento inexistente
	}

	public void update(Departamento departamento) {

		// Almacenariamos los valores del departamento en la base de datos de un
		// departamento existente

	}

	public void delete(Long id) {
		// Eliminariamos el elemento departamento que concidiera con ese id.
	}

	// Norma 4: No tiene getter/setter

}
