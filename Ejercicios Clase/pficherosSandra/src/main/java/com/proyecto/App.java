package com.proyecto;

import java.io.IOException;

import com.proyecto.dao.exceptions.DAOException;
import com.proyecto.ln.ServDepartamentos;
import com.proyecto.ln.exceptions.ServicioException;

public class App {

	public static void main(String[] args) throws DAOException, IOException, ServicioException {

		ServDepartamentos fichero = new ServDepartamentos();
		fichero.actualizarInformacion();
		fichero.generarFichero();

	}

}
