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

@WebServlet("/region/crear")
public class RegionCrearController extends HttpServlet {

	private static final Logger log = Logger.getLogger(RegionCrearController.class);

	IServicio<Integer, Region> servicio;

	public RegionCrearController() {
		super();
		this.servicio = new ServRegion();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doGet");

		

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/regionCrear.jsp");

		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("doPost");
		try {
			Integer id = Integer.valueOf(req.getParameter("id"));
			String nombre = req.getParameter("nombre");
			Region region = crearRegion(id, nombre);
			log.info(region);
			

		} catch (ServicioException e) {

			log.error(e.getMessage(), e);
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/regiones");

		rd.forward(req, resp);

	}

	private Region crearRegion(Integer id, String nombre) throws ServicioException {
		Region region = new Region();

			region.setId(id);
			region.setNombre(nombre);		
		
		this.servicio.create(region);
		return region;

	}

}
