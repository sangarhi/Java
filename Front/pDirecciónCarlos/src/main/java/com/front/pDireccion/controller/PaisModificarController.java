package com.front.pDireccion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.front.pDireccion.bussines.ServPais;
import com.front.pDireccion.bussines.interfaces.IServicio;
import com.front.pDireccion.common.exceptions.ServicioException;
import com.front.pDireccion.data.Pais;

@WebServlet("/pais/modificar")
public class PaisModificarController extends HttpServlet {

	private static final Logger log = Logger.getLogger(PaisModificarController.class);

	IServicio<String, Pais> servicio;

	public PaisModificarController() {
		super();
		this.servicio = new ServPais();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doGet");

		try {

			String key = req.getParameter("id");
			Pais pais = this.servicio.findOne(key);
			req.setAttribute("element", pais);
			log.info(pais);

		} catch (ServicioException e) {

			log.error(e.getMessage(), e);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/paisModificar.jsp");

		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("doPost");
		try {

			String key = req.getParameter("id");
			
			String nombre = req.getParameter("nombre");			
			Integer idRegion = Integer.valueOf(req.getParameter("idRegion"));
			Pais pais = modificarPais(key, nombre, idRegion);
			log.info(pais);
			req.setAttribute("element", pais);
			
			req.setAttribute("mensaje","La pais se ha modificado");

		} catch (ServicioException e) {

			log.error(e.getMessage(), e);
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/paisModificar.jsp");

		rd.forward(req, resp);

	}

	private Pais modificarPais(String id, String nombre, Integer idRegion) throws ServicioException {
		Pais pais = this.servicio.findOne(id);

		log.info("Pais en BBDD" + pais);
		if (!nombre.equalsIgnoreCase(pais.getNombre()))
			pais.setNombre(nombre);
		if (idRegion!=pais.getRegion().getId())
			pais.getRegion().setId(idRegion);

		this.servicio.update(pais);
		return pais;

	}

}
