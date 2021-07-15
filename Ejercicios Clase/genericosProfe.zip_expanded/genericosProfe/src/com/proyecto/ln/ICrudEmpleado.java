package com.proyecto.ln;

import java.util.List;

import com.proyecto.data.Empleado;

public interface ICrudEmpleado {
	//TODO A ELIMINAR PORQUE USAMOS LA GENERICA
	
	//Todos los métodos son abstract (no  tienen implementación de código)
	//Por ahora todos los métodos de una interfaz van a ser públicos. (AHORA ESTO ES MENTIRA)

	public abstract List<Empleado> selectAll();

	public  Empleado selectById(Integer idEmpleado);

	abstract int insert(Empleado empleado);

	void update(Empleado empleado);

	int delete(Integer idEmpleado);
	

}