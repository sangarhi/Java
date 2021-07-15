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
import com.front.pDireccion.data.Region;

@WebServlet("/pais/crear")
public class PaisCrearController extends HttpServlet {

	private static final Logger log = Logger.getLogger(PaisCrearController.class);

	IServicio<String, Pais> servicio;

	public PaisCrearController() {
		super();
		this.servicio = new ServPais();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doGet");

		

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/paisCrear.jsp");

		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("doPost");
		try {

			String key = req.getParameter("id");
			
			String nombre = req.getParameter("nombre");
			Integer idRegion = Integer.valueOf(req.getParameter("idRegion"));
			Pais pais = crearPais(key, nombre, idRegion);
			log.info(pais);
			

		} catch (ServicioException e) {

			log.error(e.getMessage(), e);
		}
		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/paises");

		rd.include(req, resp);

	}

	private Pais crearPais(String id, String nombre, Integer idRegion) throws ServicioException {
		Pais pais = new Pais();

			pais.setPaisId(id);
			pais.setNombre(nombre);		
				
			Region region =new Region();
			region.setId(idRegion);
			pais.setRegion(region);
			
			
		this.servicio.create(pais);
		return pais;

	}

}
