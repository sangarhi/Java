package com.front.pDireccion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.front.pDireccion.bussines.ServPais;
import com.front.pDireccion.bussines.interfaces.IServicio;
import com.front.pDireccion.common.exceptions.ServicioException;
import com.front.pDireccion.data.Pais;

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
	 * response) throws ServletException, IOException{ log.debug("doGet");
	 * PrintWriter pw= response.getWriter(); String cadena="Paises2";
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
			List<Pais> paises = this.servicio.findAll();
			req.setAttribute("listado", paises);

			HttpSession session = req.getSession();
			log.info("Mi request:" + req);
			log.info("Mi session es:" + session.getId());
			session.setAttribute("usuario", "Maria Bazan. Sesion:"+session.getId());

			Integer numSessions;
			List<String> sessionsIds;

			numSessions = (Integer) getServletContext().getAttribute("numSessions");
			sessionsIds = (List<String>) getServletContext().getAttribute("sesiones");

			if (numSessions == null) {
				log.info("PRIMERA SESION");
				numSessions = 0;
				sessionsIds = new ArrayList<String>();

			}
			log.info("Numero de sessiones:" + numSessions);

			if (!sessionsIds.contains(session.getId())) {
				log.info("INTRODUCIMOS SESSION");
				log.info("SESSION:" + session.getId());
				++numSessions;
				sessionsIds.add(session.getId());
				sessionsIds.forEach(log::info);

			}
			getServletContext().setAttribute("numSessions", numSessions);
			getServletContext().setAttribute("sesiones", sessionsIds);
			
			

		} catch (ServicioException e) {

			log.error(e.getMessage(), e);
		}

		log.info(getServletContext().getContextPath());

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/paises.jsp");

		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doPost");

		doGet(req, resp);
	}
}
