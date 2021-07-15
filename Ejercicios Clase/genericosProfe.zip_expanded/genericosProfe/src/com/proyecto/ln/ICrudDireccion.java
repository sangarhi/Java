package com.proyecto.ln;

import java.util.List;

import com.proyecto.data.Direccion;

public interface ICrudDireccion {
	
	//TODO A ELIMINAR PORQUE USAMOS LA GENERICA
	
	//Todos los métodos son abstract (no  tienen implementación de código)
	//Por ahora todos los métodos de una interfaz van a ser públicos. (AHORA ESTO ES MENTIRA)

	public abstract List<Direccion> selectAll();

	public  Direccion selectById(Integer idDireccion);

	abstract int insert(Direccion direccion);

	void update(Direccion direccion);

	int delete(Integer idDireccion);
	

}