package com.front.rrhh_Au.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.front.rrhh_Au.bussines.ServRegion;
import com.front.rrhh_Au.bussines.interfaces.IServicio;
import com.front.rrhh_Au.common.exceptions.ServicioException;
import com.front.rrhh_Au.data.Region;

@WebServlet("/region/modificar")
public class RegionModificarController extends HttpServlet {

	private static final Logger log = Logger.getLogger(RegionModificarController.class);

	IServicio<Integer, Region> servicio;

	public RegionModificarController() {
		super();
		this.servicio = new ServRegion();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doGet");

		try {

			Integer key = Integer.valueOf(req.getParameter("id"));
			Region region = this.servicio.findOne(key);
			req.setAttribute("element", region);
			log.info(region);

		} catch (ServicioException e) {

			log.error(e.getMessage(), e);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/regionModificar.jsp");

		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("doPost");
		try {

			String nombre = req.getParameter("nombre");			
			Integer id = Integer.valueOf(req.getParameter("id"));
			Region region = modificarRegion(nombre, id);
			log.info(region);
			req.setAttribute("element", region);
			
			req.setAttribute("mensaje","La region se ha modificado");

		} catch (ServicioException e) {

			log.error(e.getMessage(), e);
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/regionModificar.jsp");

		rd.forward(req, resp);

	}

	private Region modificarRegion(String nombre, Integer id) throws ServicioException {
		Region region = this.servicio.findOne(id);

		log.info("Region en BBDD" + region);
		if (!nombre.equalsIgnoreCase(region.getNombre()))
			region.setNombre(nombre);
		if (id!=region.getId())
			region.setId(id);

		this.servicio.update(region);
		return region;

	}

}
