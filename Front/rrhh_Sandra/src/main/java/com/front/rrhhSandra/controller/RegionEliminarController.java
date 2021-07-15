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
@WebServlet("/region/eliminar")
public class RegionEliminarController extends HttpServlet{
	
	private static final Logger log = Logger.getLogger(RegionEliminarController.class);
	IServicio<Integer, Region> servicio;

	public RegionEliminarController() {
		super();
		this.servicio = new ServRegion();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
log.debug("doGet");
		
		try {
			
			Integer key = Integer.valueOf(req.getParameter("id"));
			this.servicio.delete(key);
			log.info("Región Eliminada");
			
		} catch (ServicioException e) {
			
			log.error(e.getMessage(), e);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/regiones"); // Esto siempre va lo último
		rd.forward(req, resp);
	}
	
	
}
