package com.examen.mf0227_3.controller;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

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
import com.examen.mf0227_3.common.exceptions.TipoException;

import com.examen.mf0227_3.data.Bean;

/**
 * Servlet implementation class ControlBorrador
 */
@WebServlet("/")
public class BeansController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IServicio<Long,Bean> servicio;
	
	private static final Logger log = Logger.getLogger(BeansController.class);

	public BeansController() {
		super();
		this.servicio = new Servicio();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("doGet");
		try {
			List<Bean> beans;
			if(request.getParameter("tipo")!=null && !"".equals(request.getParameter("tipo").trim())) {
			beans = servicio.findByTipo();	
			log.info("beansByTipo"+beans);
			request.setAttribute("listadoByTipo", beans);
		}
			beans = servicio.findAll();
			log.info("beans"+beans);
			request.setAttribute("listado", beans);
		} catch (ServicioException e) {
			gestionExcepcion(e,request);
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/beans.jsp");
		dispatcher.forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("doPost");
		doGet(request,response);
	}

	private void gestionExcepcion(Exception e, HttpServletRequest request) {
		log.debug("gestionExcepcion");
		
		ResourceBundle rb = ResourceBundle.getBundle("error");
		String mensajeError="";
		if(e instanceof ServicioException) {
			ServicioException se = (ServicioException)e;
			log.info("Tipo Excepcion de Servicio:"+se.getTipoExcepcion().toString());
			mensajeError = rb.getString(se.getTipoExcepcion().toString());
			
		}else {
			log.info("Tipo Excepcion General:"+TipoException.EXCEPCION_GENERAL.toString());
			mensajeError = rb.getString(TipoException.EXCEPCION_GENERAL.toString());
		}
		log.info("Mensaje Error:"+mensajeError);
		request.setAttribute("error", mensajeError);
	}
	

}
