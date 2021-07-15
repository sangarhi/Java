package com.proyecto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.proyecto.dao.DepartamentoDAO;
import com.proyecto.dao.exceptions.DAOException;
import com.proyecto.dao.interfaces.IDAO;
import com.proyecto.data.Departamento;
import com.proyecto.ln.ServDepartamentos;
import com.proyecto.ln.exceptions.ServicioException;

public class App {

	public static void main(String[] args) throws DAOException, IOException, ServicioException {

		ServDepartamentos fichero = new ServDepartamentos();
		fichero.actualizarInformacion();
		fichero.generarFichero();

	}

}
