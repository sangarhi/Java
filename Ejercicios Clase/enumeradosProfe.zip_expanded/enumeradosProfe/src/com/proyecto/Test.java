package com.proyecto;

import com.proyecto.comun.Colores;
import com.proyecto.comun.MarcaDeVehiculo;
import com.proyecto.comun.Movimientos;
import com.proyecto.comun.TipoMaceta;
import com.proyecto.data.Maceta;
import com.proyecto.data.Vehiculo;
import com.proyecto.ln.Jugada;

public class Test {
	
	public static void main(String[] args) {
		//Se imprime el valor en String del Enum
		//System.out.println(Movimientos.ARRIBA);
		
		//Cada elemento es el enum en sí mismo
		//System.out.println(Movimientos.ARRIBA.ABAJO);
		
		//Listamos lo valores de Enum
		for(Movimientos movimiento:Movimientos.values()) {
			//System.out.println(movimiento);
			
		}
		//Listamos lo valores de Enum utilizando un Enum
		for(Movimientos movimiento:Movimientos.ARRIBA.values()) {
			//System.out.println(movimiento);
			
		}
		
		//Uso de Enumerados como constantes
		Jugada jugada = new Jugada();
		//System.out.println(jugada);
		jugada.mover(Movimientos.ARRIBA);
		//System.out.println(jugada);
		jugada.mover(Movimientos.ARRIBA);
		//System.out.println(jugada);
		jugada.mover(Movimientos.IZQUIERDA);
		//System.out.println(jugada);
		jugada.mover(Movimientos.IZQUIERDA);
		//System.out.println(jugada);
		
		//Uso de Enumerados como atributos
		Maceta maceta = new Maceta(1l, "MAC01", 20, 40, TipoMaceta.RECTANGULAR, Colores.NEGRO);
		//System.out.println(maceta);
		maceta.setTipoMaceta(TipoMaceta.REDONDA);
		
		//System.out.println("Volumen de mi maceta:"+ maceta.getTipoMaceta().getVolumen());
		maceta.getTipoMaceta().setVolumen(30);
		//System.out.println("Volumen nuevo de mi maceta:"+ maceta.getTipoMaceta().getVolumen());
		
		//OJO¡ Los enum los pasa directamente a String, por eso podemos concatenar directamente
		String descTipoMaceta= "Mi maceta es de tipo:"+maceta.getTipoMaceta();
		//System.out.println(descTipoMaceta);
		
		Vehiculo coche = new Vehiculo("4569 LPW", MarcaDeVehiculo.FORD);
		System.out.println(coche);
		coche.setMarca(MarcaDeVehiculo.SEAT);
		System.out.println(coche);
		
			}

}
