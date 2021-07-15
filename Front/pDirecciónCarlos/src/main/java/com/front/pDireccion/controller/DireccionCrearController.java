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
import com.front.pDireccion.data.Pais;

@WebServlet("/direccion/crear")
public class DireccionCrearController extends HttpServlet {

	private static final Logger log = Logger.getLogger(DireccionCrearController.class);

	IServicio<Long, Direccion> servicio;

	public DireccionCrearController() {
		super();
		this.servicio = new ServDireccion();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doGet");

		

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/direccionCrear.jsp");

		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("doPost");
		try {

			Long key = Long.valueOf(req.getParameter("id"));
			
			String calle = req.getParameter("calle");
			String codPostal = req.getParameter("codPostal");
			String ciudad = req.getParameter("ciudad");
			String estado = req.getParameter("estado");
			String idPais = req.getParameter("idPais");
			Direccion direccion = credarDireccion(key, calle, codPostal, ciudad, estado, idPais);
			log.info(direccion);
			

		} catch (ServicioException e) {

			log.error(e.getMessage(), e);
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/direcciones");

		rd.forward(req, resp);

	}

	private Direccion credarDireccion(Long id, String calle, String codPostal, String ciudad, String estado,
			String idPais) throws ServicioException {
		Direccion direccion = new Direccion();

			direccion.setId(id);
			direccion.setCalle(calle);		
			direccion.setCodPostal(codPostal);		
			direccion.setCiudad(ciudad);		
			direccion.setEstado(estado);	
			Pais pais=new Pais();
			/*
			 * direccion.setPais(pais); direccion.getPais().setPaisId(idPais);
			 */
			pais.setPaisId(idPais);
			direccion.setPais(pais);
			
		this.servicio.create(direccion);
		return direccion;

	}

}
