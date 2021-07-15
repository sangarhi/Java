package com.proyecto.ln;

import java.util.ArrayList;
import java.util.List;

import com.proyecto.data.Direccion;

/**
 * Operaciones (DML) del Direccion.
 * 
 * Clase de negocio: comportamiento del Direccion.
 * 
 * @author Javier
 *
 */
public class CrudDireccion implements ICrud<Direccion,Integer> {
	// Variable de instancia de Clase, con modificador de acceso por defecto.
	// Acceso: CrudDireccion repositorio = new CrudDireccion();
	// repositorio.direccion;
	Direccion direccion;
	// static Direccion direccion =null; //Variable de Clase. Acceso
	// CrudDireccion.direccion
	// Podría tener un constructor, peor normalmente no lo lleva.

	/*
	 * COMPORTAMIENTO: funcionalidad o "lógica del negocio"
	 */

	@Override
	public List<Direccion> selectAll() {

		List<Direccion> direccions = new ArrayList<Direccion>();

		// Conecta la BBDD y recoge todos los Direccions de la misma.
		System.out.println("Conecta la BBDD y recoge todos los Direccions de la misma.");

		return direccions;
	}

	@Override
	public Direccion selectById(Integer idDireccion) {
		Direccion direccion = null;

		// Obtiene los datos del Direccion cuyo id coincida con el idDireccion.
		System.out.println("Obtiene los datos del Direccion cuyo id coincida con el idDireccion.");

		return direccion;
	}

	@Override
	public int insert(Direccion direccion) {
		int resultado = 0;

		// Inserta un nuevo direccion. Retorna 1 si ha insertado Direccion, 0 en
		// caso contrario.
		System.out.println("Inserta un nuevo direccion.");

		return resultado;
	}

	@Override
	public void update(Direccion direccion) {
		//int resultado = 0;

		// Actualiza un direccion.
		System.out.println("Actualiza un direccion.");

		//return resultado;
	}

	@Override
	public int delete(Integer idDireccion) {
		int resultado = 0;

		// Elimina el Departaento cuyo id coincida con idDireccion. 
		System.out.println("Elimina el Departaento cuyo id coincida con idDireccion.");

		return resultado;
	}

	

}
