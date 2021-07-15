package com.proyecto;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.proyecto.dao.PaisDAO;
import com.proyecto.dao.exceptions.DAOException;
import com.proyecto.dao.interfaces.IDAO;
import com.proyecto.data.Pais;

public class AppPais {

	private static final Logger log = Logger.getLogger(App.class);

	public static void main(String[] args) throws DAOException {
		IDAO<String, Pais> dao = new PaisDAO();
		List<Pais> paises = new ArrayList<Pais>();
		try {
			paises = dao.findAll();
		} catch (DAOException e) {
			log.error(e.getTipoExcepcion().getMensaje());
		}
		paises.forEach(System.out::println);
		System.out.println("-----------findOne------------------------");

		System.out.println(dao.findOne("AR"));
		System.out.println("-------------create----------------------");

		Pais pais = new Pais();
		pais.setId("ES");
		pais.setCountryName("España");
		pais.setRegionId(1l);

		System.out.println("Creación País");
		dao.create(pais);

		try {
			paises = dao.findAll();
		} catch (DAOException e) {
			log.error(e.getTipoExcepcion().getMensaje());
		}
		paises.forEach(System.out::println);
		System.out.println("-----------------------------------");
		System.out.println("Actualización países");
		pais.setCountryName("Pais_modificado");
		dao.update(pais);

		try {
			paises = dao.findAll();
		} catch (DAOException e) {
			log.error(e.getTipoExcepcion().getMensaje());
		}
		paises.forEach(System.out::println);
		paises.forEach(System.out::println);
		System.out.println("-----------------------------------");
		System.out.println("Borrado país");

		dao.delete("ES");

		try {
			paises = dao.findAll();
		} catch (DAOException e) {
			log.error(e.getTipoExcepcion().getMensaje());
		}
		paises.forEach(System.out::println);

	}

}
