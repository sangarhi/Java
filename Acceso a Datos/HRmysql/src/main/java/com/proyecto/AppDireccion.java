package com.proyecto;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.proyecto.dao.DepartamentoDAO;
import com.proyecto.dao.DireccionDAO;
import com.proyecto.dao.exceptions.DAOException;
import com.proyecto.dao.interfaces.IDAO;
import com.proyecto.data.Departamento;
import com.proyecto.data.Direccion;

public class AppDireccion {

	private static final Logger log = Logger.getLogger(App.class);

	public static void main(String[] args) throws DAOException {
		IDAO<Long, Direccion> dao = new DireccionDAO();
		List<Direccion> direcciones = new ArrayList<Direccion>();
		try {
			direcciones = dao.findAll();
		} catch (DAOException e) {
			log.error(e.getTipoExcepcion().getMensaje());
		}
		direcciones.forEach(System.out::println);
		System.out.println("-----------findOne------------------------");

		System.out.println(dao.findOne(1000l));
		System.out.println("-------------create----------------------");

		Direccion direccion = new Direccion();
		direccion.setId(3300l);
		direccion.setCity("Madrid");
		direccion.setPostalCode("123456");
		direccion.setStreetAddress("calle inventada");
		direccion.setIdCountry("IT");

		System.out.println("Creación direccion");
		dao.create(direccion);

		try {
			direcciones = dao.findAll();
		} catch (DAOException e) {
			log.error(e.getTipoExcepcion().getMensaje());
		}
		direcciones.forEach(System.out::println);
		System.out.println("-----------------------------------");
		System.out.println("Actualización direcciones");
		direccion.setStreetAddress("Calle_modificada");
		dao.update(direccion);

		try {
			direcciones = dao.findAll();
		} catch (DAOException e) {
			log.error(e.getTipoExcepcion().getMensaje());
		}
		direcciones.forEach(System.out::println);
		direcciones.forEach(System.out::println);
		System.out.println("-----------------------------------");
		System.out.println("Borrado direccion");

		dao.delete(3300l);

		try {
			direcciones = dao.findAll();
		} catch (DAOException e) {
			log.error(e.getTipoExcepcion().getMensaje());
		}
		direcciones.forEach(System.out::println);

	}

}
