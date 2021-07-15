package com.proyecto.ln;

import java.util.List;

import com.proyecto.data.Direccion;

public interface ICrudDireccion {
	
	//TODO A ELIMINAR PORQUE USAMOS LA GENERICA
	
	//Todos los m�todos son abstract (no  tienen implementaci�n de c�digo)
	//Por ahora todos los m�todos de una interfaz van a ser p�blicos. (AHORA ESTO ES MENTIRA)

	public abstract List<Direccion> selectAll();

	public  Direccion selectById(Integer idDireccion);

	abstract int insert(Direccion direccion);

	void update(Direccion direccion);

	int delete(Integer idDireccion);
	

}