package com.javabasico.base;

public class ConstruccionObjetos {

	public static void main(String[] args) {
		Departamento departamento = new Departamento();
		Departamento departamento2 = new Departamento();
		departamento2=departamento;
		departamento=null;
		Departamento departamento3=departamento2;
		Departamento departamento4 = new Departamento();
		departamento4 = departamento3;
		departamento3=null;
		departamento4=null;
		departamento2=departamento4;

	}

}
