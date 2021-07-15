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
import com.front.pDireccion.bussines.interfaces.IServicio;
import com.front.pDireccion.common.exceptions.ServicioException;
import com.front.pDireccion.data.Pais;

@SuppressWarnings("serial")
@WebServlet("/paises")
public class PaisesController extends HttpServlet {

	private static final Logger log = Logger.getLogger(PaisesController.class);
	IServicio<String, Pais> servicio;

	public PaisesController() {
		super();
		this.servicio = new ServPais();
	}

	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { log.debug("doGet");
	 * PrintWriter pw = response.getWriter(); pw.
	 * println("<!DOCTYPE HTML><html><head><title>Paises</title></head><body>Paises</body></html>"
	 * ); pw.close();
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		log.debug("doGet");
		String tx = "Esto es una cadena desde Controller";
		req.setAttribute("test", tx);

		try {
			List<Pais> paises = this.servicio.findAll();
			req.setAttribute("listado", paises);
			
		} catch (ServicioException e) {

			log.error(e.getMessage(), e);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/paises.jsp"); // Esto siempre va lo
																								// último
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doPost");
		
		doGet(req, resp);
	}

}
