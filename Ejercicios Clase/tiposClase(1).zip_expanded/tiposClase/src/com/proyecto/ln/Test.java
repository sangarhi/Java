package com.proyecto.ln;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.data.Departamento;

public class Test {

	public static void main(String[] args) {
		
		//Tengo acceso a todos los elementos del objeto (cuidado si puedo acceder por sus modificadores de acceso)
		CrudDepartamento crudDepartamento = new CrudDepartamento();
		//crudDepartamento.departamento= new Departamento();
		Connection con = crudDepartamento.connectBBDD(0, "HR", "hr");
		//int numFilas=crudDepartamento.update(crudDepartamento.departamento);
		crudDepartamento.disconnect(con);
		System.out.println("CrudDepartamento:"+ crudDepartamento);
		
		ICrudDepartamento crud = new CrudDepartamento();
		Departamento departamento = new Departamento();
		//int numFilas=crud.update(departamento);
		
		
		System.out.println("ICrudDepartamento:"+ crud);
		
		IConnection conexion = new CrudDepartamento();
		conexion.connectBBDD(0, "HR", "hr");
		
		System.out.println("IConnection:"+ conexion);
		
		//Las interfaces no tienen constructor, no se pueden implementar
		//CrudDepartamento crudDepartamento = new ICrudDepartamento();
		List<Departamento> departamentos = new ArrayList<Departamento>();
		//List<Departamento> departamentos = new List<Departamento>(); NO COMPILA
		

	}

}
