package com.proyecto.ln;

import java.util.List;

import com.proyecto.data.Departamento;

public interface ICrudDepartamento {
	
	//Todos los m�todos son abstract (no  tienen implementaci�n de c�digo)
	//Por ahora todos los m�todos de una interfaz van a ser p�blicos. (AHORA ESTO ES MENTIRA)

	public abstract List<Departamento> selectAll();

	public  Departamento selectById(Integer idDepartamento);

	abstract int insert(Departamento departamento);

	void update(Departamento departamento);

	int delete(Integer idDepartamento);
	

}