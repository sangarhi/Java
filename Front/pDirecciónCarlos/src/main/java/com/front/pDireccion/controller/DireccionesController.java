package com.front.pDireccion.controller;

import java.io.IOException;
import java.util.List;

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


public class DireccionesController extends HttpServlet {

	private static final Logger log = Logger.getLogger(DireccionesController.class);

	IServicioDireccion servicio;

	public DireccionesController() {
		super();
		this.servicio = new ServDireccion();

	}

	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException{ log.debug("doGet");
	 * PrintWriter pw= response.getWriter(); String cadena="Direcciones2";
	 * pw.println("<html><body>"+cadena+"</body></html>");
	 * 
	 * pw.close(); }
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doGet");

		String texto = "Esta es una cadena desde el controller";

		req.setAttribute("pepe", texto);
		
		
		log.info(req.getContextPath());
		
		log.info(req.getPathInfo());

		try {
			List<Direccion> direcciones = this.servicio.findAll();
			List<String> codPostales = this.servicio.findAllCodPostales(direcciones);
			req.setAttribute("listado", direcciones);
			req.setAttribute("codPostales", codPostales);

		} catch (ServicioException e) {

			log.error(e.getMessage(), e);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/direcciones.jsp");
		
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doPost");
		
		doGet(req,resp);
	}
}
