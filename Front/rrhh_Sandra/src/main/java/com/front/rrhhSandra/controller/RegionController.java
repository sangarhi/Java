package com.front.rrhhSandra.controller;

import java.io.IOException;

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
@WebServlet("/region")
public class RegionController extends HttpServlet {

	private static final Logger log = Logger.getLogger(RegionesController.class);
	IServicio<Integer, Region> servicio;

	public RegionController() {
		super();
		this.servicio = new ServRegion();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doGet");

		try {

			Integer key =  Integer.valueOf(req.getParameter("id"));
			Region region = this.servicio.findOne(key);
			log.info(region);
			req.setAttribute("element", region);

		} catch (ServicioException e) {

			log.error(e.getMessage(), e);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/region.jsp"); // Esto siempre va lo �ltimo
		rd.forward(req, resp);
	}

	// Para actualizar un recurso -> DOPOST
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doPost");
		doGet(req, resp);
	}

}
