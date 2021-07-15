package com.proyecto.ln;

import com.proyecto.data.Departamento;

public class Test {

	public static void main(String[] args) {
		
		//Tengo acceso a todos los elementos del objeto (cuidado si puedo acceder por sus modificadores de acceso)
		CrudDepartamento crudDepartamento = new CrudDepartamento();
			
		ICrud<Departamento,Integer> crud = new CrudDepartamento();
		
		
		System.out.println("ICrudDepartamento:"+ crud);
		
		
		
		

	}

}
