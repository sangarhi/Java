package com.front.rrhh_Au.controller;

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

import com.front.rrhh_Au.bussines.ServRegion;
import com.front.rrhh_Au.bussines.interfaces.IServicio;
import com.front.rrhh_Au.common.exceptions.ServicioException;
import com.front.rrhh_Au.data.Region;

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
	 * response) throws ServletException, IOException{ log.debug("doGet");
	 * PrintWriter pw= response.getWriter(); String cadena="Regiones2";
	 * pw.println("<html><body>"+cadena+"</body></html>");
	 * 
	 * pw.close(); }
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doGet");

		log.info(req.getContextPath());
		
		log.info(req.getPathInfo());

		try {
			List<Region> regiones = this.servicio.findAll();
			req.setAttribute("listado", regiones);
			
			//Ejemplo de sesiones (crear y saber las que hay)	
			/*
			 * HttpSession session = req.getSession(); log.info("Mi request:" + req);
			 * log.info("Mi sesion es:"+ session.getId()); session.setAttribute("usuario",
			 * "Aurora.Sesion");
			 * 
			 * Integer numSessions = 0; List<String> sessionsIds; if(numSessions==null) {
			 * numSessions = (Integer) getServletContext().getAttribute("numSessions");
			 * sessionsIds = (List<String>) getServletContext().getAttribute("sesiones"); }
			 */
			
			/* esto pertenecia a un try que ha sido cambiado por el if OJO
			 * catch (RuntimeException re) { log.info("PRIMERA SESION"); numSessions=0;
			 * sessionsIds = new ArrayList<String>(); }
			 */
			/*
			 * log.info("NUMERO DE SESIONES: "+numSessions);
			 * if(!sessionsIds.contains(session.getId())) { log.info("INTRODUCIMOS SESION");
			 * log.info("SESSION:"+ session.getId()); ++numSessions;
			 * sessionsIds.add(session.getId()); sessionsIds.forEach(log::info); }
			 * getServletContext().setAttribute("numSessions", numSessions);
			 * getServletContext().setAttribute("sessionsIds", sessionsIds);
	
			*/
			
		} catch (ServicioException e) {

			log.error(e.getMessage(), e);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/regiones.jsp");
		
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doPost");
		
		doGet(req,resp);
	}
}
