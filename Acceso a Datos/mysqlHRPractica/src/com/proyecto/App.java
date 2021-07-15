package com.proyecto;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.proyecto.dao.DepartamentoDAO;
import com.proyecto.dao.exceptions.DAOException;
import com.proyecto.dao.interfaces.IDAO;
import com.proyecto.data.Departamento;

public class App {

	private static final Logger log = Logger.getLogger(App.class);

	public static void main(String[] args) throws DAOException {
		IDAO<Long, Departamento> dao = new DepartamentoDAO();
		List<Departamento> departamentos = new ArrayList<Departamento>();
		try {
			departamentos = dao.findAll();
		} catch (DAOException e) {
			log.error(e.getTipoExcepcion().getMensaje());
		}
		departamentos.forEach(System.out::println);
		System.out.println("-----------------------------------");
		System.out.println(dao.findOne(200l));
		System.out.println("-----------------------------------");

		Departamento departamento = new Departamento();
		departamento.setId(280l);
		departamento.setNombre("MiDepartamento");
		departamento.setIdDireccion(1700l);

		System.out.println("Creación departamento");
		dao.create(departamento);

		try {
			departamentos = dao.findAll();
		} catch (DAOException e) {
			log.error(e.getTipoExcepcion().getMensaje());
		}
		departamentos.forEach(System.out::println);
		System.out.println("-----------------------------------");
		System.out.println("Actualización departamento");
		departamento.setNombre("Departamento_modificado");
		dao.update(departamento);

		try {
			departamentos = dao.findAll();
		} catch (DAOException e) {
			log.error(e.getTipoExcepcion().getMensaje());
		}
		departamentos.forEach(System.out::println);
		System.out.println("-----------------------------------");
		System.out.println("Borrado departamento");

		dao.delete(280l);

		try {
			departamentos = dao.findAll();
		} catch (DAOException e) {
			log.error(e.getTipoExcepcion().getMensaje());
		}
		departamentos.forEach(System.out::println);

	}

}
