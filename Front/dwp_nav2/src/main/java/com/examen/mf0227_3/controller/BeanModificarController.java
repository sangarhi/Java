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
import com.examen.mf0227_3.common.Tipo;
import com.examen.mf0227_3.common.exceptions.ServicioException;
import com.examen.mf0227_3.data.Bean;

@WebServlet("/bean/modificar")
public class BeanModificarController extends HttpServlet {

	private static final Logger log = Logger.getLogger(BeanModificarController.class);

	IServicio<Long, Bean> servicio;

	public BeanModificarController() {
		super();
		this.servicio = new Servicio();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doGet");

		try {

			Long key = Long.valueOf(req.getParameter("id"));
			Bean bean = this.servicio.findOne(key);
			req.setAttribute("element", bean);
			log.info(bean);
			
			req.setAttribute("tipos", Tipo.values());

		} catch (ServicioException e) {

			log.error(e.getMessage(), e);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/beanModificar.jsp");

		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("doPost");
		try {

			Long key = Long.valueOf(req.getParameter("id"));
			
			String nombre = req.getParameter("nombre");			
			Long tipo = Long.valueOf(req.getParameter("tipo"));
			Bean bean = modificarBean(key, nombre, tipo);
			log.info(bean);
			req.setAttribute("element", bean);
			
			req.setAttribute("tipos", Tipo.values());
			
			req.setAttribute("mensaje","La bean se ha modificado");

		} catch (ServicioException e) {

			log.error(e.getMessage(), e);
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/beanModificar.jsp");

		rd.forward(req, resp);

	}

	private Bean modificarBean(Long id, String nombre, Long tipo) throws ServicioException {
		Bean bean = this.servicio.findOne(id);

		log.info("Bean en BBDD" + bean);
		if (!nombre.equalsIgnoreCase(bean.getNombre()))
			bean.setNombre(nombre);
		if (tipo!=bean.getTipo())
			bean.setTipo(tipo);

		this.servicio.update(bean);
		return bean;

	}

}
