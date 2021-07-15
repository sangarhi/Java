package com.front.pDireccion.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.front.pDireccion.bussines.ServPais;
import com.front.pDireccion.bussines.ServRegion;
import com.front.pDireccion.bussines.interfaces.IServicio;
import com.front.pDireccion.common.exceptions.ServicioException;
import com.front.pDireccion.data.Pais;
import com.front.pDireccion.data.Region;

@SuppressWarnings("serial")
@WebServlet("/pais/crear")
public class PaisCrearController extends HttpServlet {

	private static final Logger log = Logger.getLogger(PaisCrearController.class);
	IServicio<Integer, Region> servicioRegion;
	IServicio<String, Pais> servicioPais;

	public PaisCrearController() {
		super();
		this.servicioPais = new ServPais();
		this.servicioRegion = new ServRegion();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doGet");

		List<Region> regiones;
		
		try {
			regiones = this.servicioRegion.findAll();
			req.setAttribute("regiones", regiones);
		} catch (ServicioException e) {

			log.error(e.getMessage(), e);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/paisCrear.jsp"); // Esto siempre va lo
		// último
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info(resp);
		try {

			String key = req.getParameter("paisId");
			String nombre = req.getParameter("nombre");
			Integer id = Integer.valueOf(req.getParameter("idRegion"));
			Pais pais = crearPais(key, nombre, id);
			log.info(pais);

		} catch (ServicioException e) {

			log.error(e.getMessage(), e);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/paises"); // Esto siempre va lo
																					// último
		rd.forward(req, resp);
	}

	private Pais crearPais(String paisId, String nombre, Integer idRegion) throws ServicioException {

		Pais pais = new Pais();

		pais.setPaisId(paisId);
		pais.setNombre(nombre);
		Region region = new Region();
		// pais.setPais(pais);
		// pais.getPais().setPaisId(idPais);
		region.setId(idRegion);
		pais.setRegion(region); // se puede hacer así, o de la forma de arriba comentada

		this.servicioPais.create(pais);
		return pais;

	}
}
