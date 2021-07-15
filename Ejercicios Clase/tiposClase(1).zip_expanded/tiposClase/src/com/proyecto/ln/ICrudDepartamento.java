package com.proyecto.ln;

import java.util.List;

import com.proyecto.data.Departamento;

public interface ICrudDepartamento {
	
	//Todos los métodos son abstract (no  tienen implementación de código)
	//Por ahora todos los métodos de una interfaz van a ser públicos. (AHORA ESTO ES MENTIRA)

	public abstract List<Departamento> selectAll();

	public  Departamento selectById(Integer idDepartamento);

	abstract int insert(Departamento departamento);

	void update(Departamento departamento);

	int delete(Integer idDepartamento);
	

}