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

@WebServlet("/region/borrar")
public class RegionBorrarController extends HttpServlet {

	private static final Logger log = Logger.getLogger(RegionBorrarController.class);

	IServicio<Integer, Region> servicio;

	public RegionBorrarController() {
		super();
		this.servicio = new ServRegion();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doGet");

		try {

			Integer key = Integer.valueOf(req.getParameter("id"));
			this.servicio.delete(key);
			log.info("Se ha eliminado");

		} catch (ServicioException e) {

			log.error(e.getMessage(), e);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/regiones");

		rd.forward(req, resp);
	}
}
