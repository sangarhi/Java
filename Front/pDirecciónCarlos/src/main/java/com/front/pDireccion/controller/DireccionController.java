package com.front.pDireccion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.front.pDireccion.bussines.ServDireccion;
import com.front.pDireccion.bussines.interfaces.IServicio;
import com.front.pDireccion.bussiness.interfaces.IServicioDireccion;
import com.front.pDireccion.common.exceptions.ServicioException;
import com.front.pDireccion.data.Direccion;

public class DireccionController extends HttpServlet {

	private static final Logger log = Logger.getLogger(DireccionController.class);

	IServicioDireccion servicio;

	public DireccionController() {
		super();
		this.servicio = new ServDireccion();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doGet");

		try {

			Long key = Long.valueOf(req.getParameter("id"));
			Direccion direccion = this.servicio.findOne(key);
			req.setAttribute("element", direccion);
			log.info(direccion);

		} catch (ServicioException e) {

			log.error(e.getMessage(), e);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/direccion.jsp");

		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doPost");

		doGet(req, resp);

	}
}
