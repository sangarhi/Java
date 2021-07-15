package com.front.rrhhSandra.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.front.rrhhSandra.business.ServRegion;
import com.front.rrhhSandra.business.interfaces.IServicio;
import com.front.rrhhSandra.common.exceptions.ServicioException;
import com.front.rrhhSandra.data.Region;

@SuppressWarnings("serial")
@WebServlet("/regiones")
public class RegionesController extends HttpServlet {

	private static final Logger log = Logger.getLogger(RegionesController.class);
	IServicio<Integer, Region> servicio;

	public RegionesController() {
		super();
		this.servicio = new ServRegion();
	}

	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { log.debug("doGet");
	 * PrintWriter pw = response.getWriter(); pw.
	 * println("<!DOCTYPE HTML><html><head><title>Regiones</title></head><body>Regiones</body></html>"
	 * ); pw.close();
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		log.debug("doGet");

		try {
			List<Region> regiones = this.servicio.findAll();
			req.setAttribute("listado", regiones);

		} catch (ServicioException e) {

			log.error(e.getMessage(), e);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/regiones.jsp"); // Esto siempre va lo
																						// último
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doPost");

		doGet(req, resp);
	}

}
