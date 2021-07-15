package com.proyecto.data;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.HyperlinkEvent.EventType;

import com.proyecto.common.TipoHabitacion;

public class Casa {
	
	private int numHabitaciones;
	private int numBanio;
	private double m2;
	private List<Habitacion> habitaciones;
	
	public Casa() {
		habitaciones = new ArrayList<Habitacion>();	
		
	}
	
	//Declaramos la clase estática inmobiliaria
	//La clase anidada estática NO TIENE ACCESO a los datos de la clase envolvente
		public static class Inmobiliaria{
		private String nombre;

		public Inmobiliaria(){
			//numHabitaciones=2;
		}
		
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}		  
		
	}
	
	public class Habitacion{
		private TipoHabitacion tipo;
		private double m2Hab;//No podemos llamarla m2 porque sería ambiguo 
							 //porque también se tiene  acceso a Casa.m2
		
		public Habitacion(TipoHabitacion tipo) {
			this.tipo=tipo;
			habitaciones.add(this);
			numHabitaciones = habitaciones.size();
			
		}
		
		public TipoHabitacion getTipoHabitacion() {
			return this.tipo;
		}
		public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
			this.tipo=tipoHabitacion;
		}		
		
	}
	
	
	
	public int getNumHabitaciones() {
		return numHabitaciones;
	}
	
	
	
	public int getNumBanio() {
		return numBanio;
	}
	
	public void setNumBanio(int numBanio) {
		this.numBanio = numBanio;
	}
	
	
	public void miMetodoConClase(int evento) {
		
		//LOCAL INNER CLASSES
		//ManejadorEvento --> EventHandler
		//EL AMBITO DE LA CLASE ES EL PROPIO METODO,solo puede usarse el propio metodo
		class ManejadorEvento{
			
			  private int evento;
			  
			  public ManejadorEvento(int evento) {
				 this.evento=evento;
			  }
			  public void imprimirEvento() {
				  System.out.println("Evento:"+this.evento);				  
			  }
			
			
		}
		
		new ManejadorEvento(evento).imprimirEvento();		
		
	}
		
	

}
