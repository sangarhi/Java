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

@WebServlet("/bean")
public class BeanController extends HttpServlet {

	private static final Logger log = Logger.getLogger(BeanController.class);

	IServicio<Long, Bean> servicio;

	public BeanController() {
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

		} catch (ServicioException e) {

			log.error(e.getMessage(), e);
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/bean.jsp");

		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doPost");

		doGet(req, resp);

	}

}
