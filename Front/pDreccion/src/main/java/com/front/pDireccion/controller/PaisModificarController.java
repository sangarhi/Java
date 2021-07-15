package com.front.pDireccion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.front.pDireccion.bussines.ServDireccion;
import com.front.pDireccion.bussines.interfaces.IServicio;
import com.front.pDireccion.common.exceptions.ServicioException;
import com.front.pDireccion.data.Direccion;

@SuppressWarnings("serial")
@WebServlet("/direccion/modificar")
public class PaisModificarController extends HttpServlet{
	
	private static final Logger log = Logger.getLogger(PaisModificarController.class);
	IServicio<Long, Direccion> servicio;

	public PaisModificarController() {
		super();
		this.servicio = new ServDireccion();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
log.debug("doGet");
		
		try {
			
			Long key = Long.valueOf(req.getParameter("id"));
			Direccion direccion =  this.servicio.findOne(key);
			log.info(direccion);
			req.setAttribute("element", direccion);
			
		} catch (ServicioException e) {
			
			log.error(e.getMessage(), e);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/direccionModifcar.jsp"); // Esto siempre va lo último
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info(resp);
		try {

			Long key = Long.valueOf(req.getParameter("id"));
			String calle = req.getParameter("calle"); 
			String codPostal = req.getParameter("codPostal"); 
			String ciudad = req.getParameter("ciudad"); 
			String estado = req.getParameter("estado");
			String idPais = req.getParameter("idPais");
			Direccion direccion =  modificarDireccion(key, calle, codPostal, ciudad, estado, idPais);
			log.info(direccion);
			req.setAttribute("element", direccion);
			req.setAttribute("mensaje", "La dirección se ha modificado");

		} catch (ServicioException e) {

			log.error(e.getMessage(), e);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/direccionModifcar.jsp"); // Esto siempre va lo
																									// último
		rd.forward(req, resp);
	}
	
	private Direccion modificarDireccion(Long id, String calle, String codPostal, String ciudad, String estado, String idPais) throws ServicioException {
		
		Direccion direccion =  this.servicio.findOne(id);
		log.info("Direccion en BBDD " + direccion);
		
		if (!calle.equalsIgnoreCase(direccion.getCalle())) 
			direccion.setCalle(calle);
		if (!codPostal.equalsIgnoreCase(direccion.getCodPostal())) 
			direccion.setCodPostal(codPostal);
		if (!ciudad.equalsIgnoreCase(direccion.getCiudad())) 
			direccion.setCiudad(ciudad);
		if (!estado.equalsIgnoreCase(direccion.getEstado())) 
			direccion.setEstado(estado);
		if (!idPais.equalsIgnoreCase(direccion.getPais().getPaisId()))
			direccion.getPais().setPaisId(idPais);
			
		this.servicio.update(direccion);
		return direccion;
		
	}
}
