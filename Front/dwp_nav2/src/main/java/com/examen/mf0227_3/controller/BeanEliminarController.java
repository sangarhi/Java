package com.examen.mf0227_3.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.examen.mf0227_3.bussines.Servicio;
import com.examen.mf0227_3.bussines.interfaces.IServicio;
import com.examen.mf0227_3.common.exceptions.ServicioException;
import com.examen.mf0227_3.data.Bean;

@WebServlet("/bean/eliminar")
public class BeanEliminarController extends HttpServlet {

	private static final Logger log = Logger.getLogger(BeanEliminarController.class);

	IServicio<Long, Bean> servicio;

	public BeanEliminarController() {
		super();
		this.servicio = new Servicio();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doGet");
				
		try {
			Long id = Long.valueOf(req.getParameter("id"));

			this.servicio.delete(id);
			log.info("elemento eliminado");

			
			
		} catch (ServicioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/");

		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("doPost");
		doGet(req,resp);

	}

	
}
