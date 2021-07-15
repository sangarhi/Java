package com.proyecto.ln;

import java.util.List;

import com.proyecto.data.Empleado;

public interface ICrudEmpleado {
	//TODO A ELIMINAR PORQUE USAMOS LA GENERICA
	
	//Todos los m�todos son abstract (no  tienen implementaci�n de c�digo)
	//Por ahora todos los m�todos de una interfaz van a ser p�blicos. (AHORA ESTO ES MENTIRA)

	public abstract List<Empleado> selectAll();

	public  Empleado selectById(Integer idEmpleado);

	abstract int insert(Empleado empleado);

	void update(Empleado empleado);

	int delete(Integer idEmpleado);
	

}