package com.proyecto.ln;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import com.proyecto.data.Departamento;

/**
 * Operaciones (DML) del Departamento.
 * 
 * Clase de negocio: comportamiento del Departamento.
 * 
 * @author Javier
 *
 */
public class CrudDepartamento implements ICrud<Departamento,Integer> {
	// Variable de instancia de Clase, con modificador de acceso por defecto.
	// Acceso: CrudDepartamento repositorio = new CrudDepartamento();
	// repositorio.departamento;
	Departamento department;
	// static Departamento departamento =null; //Variable de Clase. Acceso
	// CrudDepartamento.departamento
	// Podría tener un constructor, peor normalmente no lo lleva.

	/*
	 * COMPORTAMIENTO: funcionalidad o "lógica del negocio"
	 */

	@Override
	public List<Departamento> selectAll() {

		List<Departamento> departamentos = new ArrayList<Departamento>();

		// Conecta la BBDD y recoge todos los Departamentos de la misma.
		System.out.println("Conecta la BBDD y recoge todos los Departamentos de la misma.");

		return departamentos;
	}

	@Override
	public Departamento selectById(Integer idDepartamento) {
		Departamento departamento = null;

		// Obtiene los datos del Departamento cuyo id coincida con el idDepartamento.
		System.out.println("Obtiene los datos del Departamento cuyo id coincida con el idDepartamento.");

		return departamento;
	}

	@Override
	public int insert(Departamento departamento) {
		int resultado = 0;

		// Inserta un nuevo departamento. Retorna 1 si ha insertado Departamento, 0 en
		// caso contrario.
		System.out.println("Inserta un nuevo departamento.");

		return resultado;
	}

	@Override
	public void update(Departamento departamento) {
		int resultado = 0;

		// Actualiza un departamento.
		System.out.println("Actualiza un departamento.");

		//return resultado;
	}

	@Override
	public int delete(Integer idDepartamento) {
		int resultado = 0;

		// Elimina el Departaento cuyo id coincida con idDepartamento. 
		System.out.println("Elimina el Departaento cuyo id coincida con idDepartamento.");

		return resultado;
	}

	

}
