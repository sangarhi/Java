package com.proyecto.ln;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.proyecto.common.Constantes;
import com.proyecto.common.DepartamentoUtils;
import com.proyecto.common.util.FileHelper;
import com.proyecto.dao.DepartamentoDAO;
import com.proyecto.dao.exceptions.DAOException;
import com.proyecto.dao.interfaces.IDAO;
import com.proyecto.data.Departamento;
import com.proyecto.ln.exceptions.CodeErrors;
import com.proyecto.ln.exceptions.ServicioException;
import com.proyecto.ln.exceptions.UtilExceptions;
import com.proyecto.ln.interfaces.Departamentos;

public class ServDepartamentos implements Departamentos {
	private static final Logger log = Logger.getLogger(ServDepartamentos.class);

	IDAO<Departamento, Long> dao;

	public ServDepartamentos() {
		super();
		this.dao = new DepartamentoDAO();
	};

	@Override
	public void generarFichero() throws ServicioException {
		log.debug("[Generating files]");

		List<String> lineas = new ArrayList<String>();
		try {
			// BBDDD
			List<Departamento> departamentos;
			// Buscamos departamentos en BBDD
			departamentos = dao.findAll();

			// Formteamos los departamentos
			for (Departamento deps : departamentos) {
				lineas.add(DepartamentoUtils.toFormatCSV(deps));
			}
			// FICHEROS
			// Escribimos en fichero
			Path path = Paths.get("Departamentos.txt");
			FileHelper.writeLines(path, lineas);

		} catch (IOException ioe) {
			log.error(ioe.getMessage(), ioe);
			throw new ServicioException(CodeErrors.FICHERO_NO_GENERADO);
		} catch (DAOException daoe) {
			log.error(daoe.getTipoExcepcion());
			throw UtilExceptions.procesarDAOException(daoe);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ServicioException(CodeErrors.PETICION_NO_PROCESADA);
		}
	}

	@Override
	public void actualizarInformacion() throws ServicioException {
		log.debug("[Updating]");

		try {

			// Leemos datos
			Path path = Paths.get("DepartamentosLoad.txt");
			List<String> lineas = FileHelper.readLines(path);

			// Convertimos en departmentos y filtramos que operacion vamos a realizar
			for (String linea : lineas) {

				Departamento departamento = DepartamentoUtils.createDepartamento(linea);

				String[] campos = linea.split(";");
				if (campos.length > 4) {
					String accion = campos[4];

					// Procesamos los departamentos marcados:

					switch (accion) {
					// - Actualizamos en BBDD
					case Constantes.MODIFICAR:
						dao.update(departamento);
						break;
					// - Creamos en BBDD
					case Constantes.CREAR:
						dao.create(departamento);
						break;
					// - Eliminamos en BBDD
					case Constantes.ELIMINAR:
						dao.delete(departamento.getId());
						break;
					}
				}

			}

		} catch (IOException ioe) {
			log.error(ioe.getMessage(), ioe);
			throw new ServicioException(CodeErrors.FICHERO_NO_GENERADO);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ServicioException(CodeErrors.PETICION_NO_PROCESADA);
		}

	}

}
