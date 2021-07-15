package com.proyecto.ln.interfaces;

import com.proyecto.ln.exceptions.ServicioException;

public interface Departamentos {
	
	public void generarFichero() throws ServicioException;
	
	public void actualizarInformacion() throws ServicioException;

}
