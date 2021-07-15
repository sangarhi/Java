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
@WebServlet("/region/modificar")
public class RegionModificarController extends HttpServlet{
	
	private static final Logger log = Logger.getLogger(RegionModificarController.class);
	IServicio<Integer, Region> servicio;

	public RegionModificarController() {
		super();
		this.servicio = new ServRegion();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
log.debug("doGet");
		
		try {
			
			Integer key = Integer.valueOf(req.getParameter("id")); 
			Region region =  this.servicio.findOne(key);
			log.info(region);
			req.setAttribute("element", region);
			
		} catch (ServicioException e) {
			
			log.error(e.getMessage(), e);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/regionModifcar.jsp"); // Esto siempre va lo último
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info(resp);
		try {

			Integer id = Integer.valueOf(req.getParameter("id"));
			String nombre = req.getParameter("nombre");
			Region region =  modificarRegion(id, nombre);
			log.info(region);
			req.setAttribute("element", region);
			req.setAttribute("mensaje", "La dirección se ha modificado");

		} catch (ServicioException e) {

			log.error(e.getMessage(), e);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/regionModifcar.jsp"); // Esto siempre va lo
																									// último
		rd.forward(req, resp);
	}
	
	private Region modificarRegion(Integer id, String nombre ) throws ServicioException {
		
		Region region =  this.servicio.findOne(id);
		log.info("Region en BBDD " + region);
		
		if (id != region.getId())
			region.setId(id);
		if (!nombre.equalsIgnoreCase(region.getNombre())) 
			region.setNombre(nombre);
			
		this.servicio.update(region);
		return region;
		
	}
}
