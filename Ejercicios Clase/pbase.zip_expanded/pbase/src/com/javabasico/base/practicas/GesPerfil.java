package com.javabasico.base.practicas;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


//Implementar el código necesario para realizar un CRUD de Perfil. Realizar una clase de negocio
public class GesPerfil implements IGenerica<Perfil, Integer> {
	
	Perfil perfil;
	
	
	@Override
	public List<Perfil> selectAll() {
		
		List<Perfil> perfiles = new ArrayList<Perfil>();
		System.out.println("Conecta la base de datos  y recoge todos los Perfiles de la misma.");
		
		return perfiles;
	}
	
	@Override
	public Perfil selectById(Integer idPerfil) {
		
		Perfil perfil = null;
		System.out.println("Obtiene los datos del Perfil cuyo id coincida con el idPerfil.");
		
		return perfil;
	}
	
	@Override
	public int insert(Perfil perfil) {
		
		int resultado = 0;
		System.out.println("Inserta un nuevo perfil");
		
		return resultado;
	}
	
	@Override
	public void update(Perfil perfil) {
		int resultado = 0;
		System.out.println("Actualiza un perfil");
		
	}
	
	@Override
	public int delete(Integer idPerfil) {
		
		int resultado = 0;
		System.out.println("Elimina el Perfil cuyo id coincida con idPerfil");
		
		return resultado;
	}
	
	public Connection connectBBDD(int tipoConexion, String user, String password) {
		
		System.out.println("Conectar bbdd");
		return null;
	}
	
	public void disconnect(Connection conn) {
		
		System.out.println("Desconectar bbdd");
	}

	
	
	
}
