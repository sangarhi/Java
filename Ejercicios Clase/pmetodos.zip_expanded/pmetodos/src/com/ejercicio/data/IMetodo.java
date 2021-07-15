package com.ejercicio.data;

public interface IMetodo {
	
	//Paso 1: Crear un metodo llamado "metodo" sin parametros que devuelva cadena
	String metodo();
	
	//Paso 2: Crear un metodo llamado "metodo" con una cadena como parametro que devuelva cadena
	String metodo(String cadena);
	
	//Paso 3: Crear un metodo llamado "metodoPadre" con una cadena y un objeto entero como parametro
	//devuelve cadena
	String metodoPadre(String cadena, Integer numero);

}
