package com.proyecto.ln;

import java.util.ArrayList;
import java.util.List;

import com.proyecto.data.Empleado;

/**
 * Operaciones (DML) del Empleado.
 * 
 * Clase de negocio: comportamiento del Empleado.
 * 
 * @author Javier
 *
 */
public class CrudEmpleado implements ICrud<Empleado,Integer> {
	// Variable de instancia de Clase, con modificador de acceso por defecto.
	// Acceso: CrudEmpleado repositorio = new CrudEmpleado();
	// repositorio.empleado;
	Empleado empleado;
	// static Empleado empleado =null; //Variable de Clase. Acceso
	// CrudEmpleado.empleado
	// Podría tener un constructor, peor normalmente no lo lleva.

	/*
	 * COMPORTAMIENTO: funcionalidad o "lógica del negocio"
	 */

	@Override
	public List<Empleado> selectAll() {

		List<Empleado> empleados = new ArrayList<Empleado>();

		// Conecta la BBDD y recoge todos los Empleados de la misma.
		System.out.println("Conecta la BBDD y recoge todos los Empleados de la misma.");

		return empleados;
	}

	@Override
	public Empleado selectById(Integer idEmpleado) {
		Empleado empleado = null;

		// Obtiene los datos del Empleado cuyo id coincida con el idEmpleado.
		System.out.println("Obtiene los datos del Empleado cuyo id coincida con el idEmpleado.");

		return empleado;
	}

	@Override
	public int insert(Empleado empleado) {
		int resultado = 0;

		// Inserta un nuevo empleado. Retorna 1 si ha insertado Empleado, 0 en
		// caso contrario.
		System.out.println("Inserta un nuevo empleado.");

		return resultado;
	}

	@Override
	public void update(Empleado empleado) {
		//int resultado = 0;

		// Actualiza un empleado.
		System.out.println("Actualiza un empleado.");

		//return resultado;
	}

	@Override
	public int delete(Integer idEmpleado) {
		int resultado = 0;

		// Elimina el Departaento cuyo id coincida con idEmpleado. 
		System.out.println("Elimina el Departaento cuyo id coincida con idEmpleado.");

		return resultado;
	}

	

}
