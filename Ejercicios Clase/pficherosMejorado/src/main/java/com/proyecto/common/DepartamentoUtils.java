package com.proyecto.common;

import com.proyecto.data.Departamento;

public class DepartamentoUtils {
	
	Departamento departamento = new Departamento();
	
	public static Departamento createDepartamento(String csv) {
		Departamento departamento = new Departamento();
		String[] campos = csv.split(";");
		departamento.setId(Long.parseLong(campos[0]));
		departamento.setNombre(campos[1]);
		if (!Constantes.NULO.equals(campos[2]))
			departamento.setIdManager(Long.parseLong(campos[2]));
		if (!Constantes.NULO.equals(campos[3]))
			departamento.setIdDireccion(Long.parseLong(campos[3]));

		return departamento;
	}

	public static String toFormatCSV(Departamento departamento) {
		return departamento.getId()+ ";" + departamento.getNombre() + ";" + departamento.getIdManager() + ";" + departamento.getIdDireccion();
	}

}
