package com.examen.mf0227_3.controller;

import java.io.IOException;
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
import com.examen.mf0227_3.common.Constantes;
import com.examen.mf0227_3.common.Tipo;
import com.examen.mf0227_3.common.exceptions.ServicioException;
import com.examen.mf0227_3.common.exceptions.TipoException;
import com.examen.mf0227_3.data.Bean;


/**
 * Servlet implementation class BorradorController
 */
@WebServlet("/bean")
public class BeanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IServicio<Long,Bean> servicio;

	private static final Logger log = Logger.getLogger(BeanController.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BeanController() {
		super();
		this.servicio = new Servicio();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("doGet");
		
		String jsp="/bean.jsp";

		String accion= request.getParameter("accion");
		
		if(accion!=null) accion = accion.trim();
		switch(accion) {

		case Constantes.FORMULARIO_MODIFICAR:{
			prepararFormModificacion(request,response);
		}
		case Constantes.FORMULARIO_CREAR:
			break;
		case Constantes.VISUALIZAR:
			visualizar(request,response);	
			break;	
		case Constantes.CREAR:
			crear(request,response);
			jsp="/";
			break;
		case Constantes.MODIFICAR:
			modificar(request,response);
			break;
		case Constantes.ELIMINAR:
			eliminar(request,response);	
			jsp="/";
			break;
		

		}
		request.setAttribute("tipos", Tipo.values());

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request,response);
	}

	private void prepararFormModificacion(HttpServletRequest request, HttpServletResponse response) {
		log.debug("prepararFormModificacion");
		try {
			if(request.getParameter("id")==null && "".equals(request.getParameter("id").trim())) {
				Long id = Long.valueOf(request.getParameter("id"));
				Bean bean = this.servicio.findOne(id);
				request.setAttribute("elemento", bean);
			}else {
				throw new Exception();
			}
		} catch (NumberFormatException e) {
			gestionExcepcion(e,request);
		} catch (ServicioException e) {
			gestionExcepcion(e,request);
		} catch (Exception e) {
			gestionExcepcion(e,request);
		}


	}
	
	private void visualizar(HttpServletRequest request, HttpServletResponse response) {
		log.debug("visualizar");
		try {
			Bean bean = new Bean();
			if(request.getParameter("id")!=null && !"".equals(request.getParameter("id").trim())) {
				Long id = Long.valueOf(request.getParameter("id"));	
				bean = this.servicio.findOne(id);
				request.setAttribute("elemento", bean);
			}else {
				throw new Exception();
			}
		} catch (NumberFormatException e) {
			gestionExcepcion(e,request);
		} catch (ServicioException e) {
			gestionExcepcion(e,request);
		} catch (Exception e) {
			gestionExcepcion(e,request);
		}

	}
	private void modificar(HttpServletRequest request, HttpServletResponse response) {
		log.debug("modificar");
		try {
			Bean bean = new Bean();
			if((request.getParameter("id")!=null && !"".equals(request.getParameter("id").trim())) &&
					(request.getParameter("nombre")!=null && !"".equals(request.getParameter("nombre").trim())) &&					
					(request.getParameter("tipo")!=null && !"".equals(request.getParameter("tipo").trim()))) {
				Long id = Long.valueOf(request.getParameter("id"));	
				bean.setId(id);
				bean = this.servicio.findOne(id);
				bean.setNombre(request.getParameter("nombre"));
				Long tipo = Long.valueOf(request.getParameter("tipo"));
				bean.setTipo(tipo);
				this.servicio.update(bean);
				request.setAttribute("elemento", bean);
			}else {
				throw new Exception();
			}
		} catch (NumberFormatException e) {
			gestionExcepcion(e,request);
		} catch (ServicioException e) {
			gestionExcepcion(e,request);
		} catch (Exception e) {
			gestionExcepcion(e,request);
		}

	}
	private void crear(HttpServletRequest request, HttpServletResponse response) {
		log.debug("crear");
		try {
			Bean bean = new Bean();
			if((request.getParameter("nombre")!=null && !"".equals(request.getParameter("nombre").trim())) &&					
					(request.getParameter("tipo")!=null && !"".equals(request.getParameter("tipo").trim()))) {
				bean.setNombre(request.getParameter("nombre"));
				Long tipo = Long.valueOf(request.getParameter("tipo"));
				bean.setTipo(tipo);
				this.servicio.create(bean);
			}else {
				throw new Exception();
			}
		} catch (NumberFormatException e) {
			gestionExcepcion(e,request);
		} catch (ServicioException e) {
			gestionExcepcion(e,request);
		} catch (Exception e) {
			gestionExcepcion(e,request);
		}

	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		log.debug("eliminar");
		try {
			if(request.getParameter("id")!=null && !"".equals(request.getParameter("id").trim())) {
				Long id = Long.valueOf(request.getParameter("id"));	
				this.servicio.delete(id);
				
			}else {
				throw new Exception();
			}
		} catch (NumberFormatException e) {
			gestionExcepcion(e,request);
		} catch (ServicioException e) {
			gestionExcepcion(e,request);
		} catch (Exception e) {
			gestionExcepcion(e,request);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("doPost");
		doGet(request,response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("doPut");
		doGet(request,response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("doDelete");
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
