package com.proyecto.ln.exceptions;

import com.proyecto.dao.exceptions.DAOException;

public class UtilExceptions {

	public static ServicioException procesarDAOException(DAOException dao) {
		ServicioException se;
		switch (dao.getTipoExcepcion()) {
		case ELEMENTO_NO_ENCONTRADO:
			se = new ServicioException(CodeErrors.ELEMENTO_NO_ENCONTRADO);
			break;
		case ELEMENTO_NO_CREADO:
			se = new ServicioException(CodeErrors.ELEMENTO_NO_CREADO);
			break;
		case ELEMENTO_NO_ACTUALIZADO:
			se = new ServicioException(CodeErrors.ELEMENTO_NO_ACTUALIZADO);
			break;
		case ELEMENTO_NO_ELIMINADO:
			se = new ServicioException(CodeErrors.ELEMENTO_NO_ELIMINADO);
			break;
		case ELEMENTO_DUPLICADO:
		case EXCEPCION_DAO:
		case OPERACION_NO_REALIZADA:
		case EXCEPCION_SQL:
			se = new ServicioException(CodeErrors.PETICION_NO_PROCESADA);
			break;
		default:
			se = new ServicioException(CodeErrors.GENERAL);

		}
		return se;
	}

}
