package com.proyecto;

import com.proyecto.common.TipoHabitacion;
import com.proyecto.data.Casa;
import com.proyecto.data.Casa.Inmobiliaria;
import com.proyecto.ln.ISaludar;
import com.proyecto.ln.Saludo;

public class Test {

	public static void main(String[] args) {
		Casa casa = new Casa();
		
		System.out.println(casa);
		
		//CLASE INTERNA ESTATICA
		//La clase estática no necesita la instancia de la clase envolvente
		//para instanciarse
		Inmobiliaria inmobiliaria = new Inmobiliaria();		
		inmobiliaria.setNombre("VendoCompro S.A");
		System.out.println("Nombre Inmobiliria:"+inmobiliaria.getNombre());
		
		System.out.println("Inmobiliaria:"+inmobiliaria);
		
		//CLASE INTERNA
		//INNER CLASS
		//La clase interna NECESITA la instancia de la clase envolvente
		//para instanciarse
		Casa.Habitacion habitacion =  casa.new Habitacion(TipoHabitacion.SALON);
		Casa.Habitacion habitacion2 = casa.new Habitacion(TipoHabitacion.COCINA);
		System.out.println("Num Habitaciones: "+ casa.getNumHabitaciones());
		System.out.println("Habitacion:"+habitacion);
		System.out.println("Habitacion:"+habitacion2);
		
		//CLASE INTERNA
		//ANONYMOUS INNER CLASS
		
		Saludo saludo = new Saludo();
		saludo.saludar("Test");
		
		ISaludar saludo2 = new Saludo();		
		saludo2.saludar("Test-tipo interfaz");
		
		//GENERO  UNA ANONYMOUS INNER CLASS CON EL CONTENIDO DE SALUDO
		ISaludar saludo3 = new ISaludar() {
			
			private String nombre;
			
			@Override
			public void saludar(String nombre) {
				this.nombre=nombre;
				System.out.println("Hola "+nombre);
				
			}			
		};
		saludo3.saludar("Test- anonymous class");
		
		
		
		
		
		

	}

}
