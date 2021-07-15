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

@SuppressWarnings("serial")
@WebServlet("/pais")
public class PaisController extends HttpServlet {

	private static final Logger log = Logger.getLogger(PaisesController.class);
	IServicio<String, Pais> servicio;

	public PaisController() {
		super();
		this.servicio = new ServPais();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doGet");

		try {

			String key = req.getParameter("id");
			Pais pais = this.servicio.findOne(key);
			log.info(pais);
			req.setAttribute("element", pais);

		} catch (ServicioException e) {

			log.error(e.getMessage(), e);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/pais.jsp"); // Esto siempre va lo último
		rd.forward(req, resp);
	}

	// Para actualizar un recurso -> DOPOST
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doPost");
		doGet(req, resp);
	}

}
