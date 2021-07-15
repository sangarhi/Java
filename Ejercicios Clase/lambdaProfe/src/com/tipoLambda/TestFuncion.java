package com.tipoLambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.tipoLambda.data.Casa;
import com.tipoLambda.interfaces.IFuncion;
import com.tipoLambda.ln.Funcion;

public class TestFuncion {

	public static void main(String[] args) {
		Stream stream1 = new Stream(new Casa());

		Casa casa = new Casa();
		casa.setNumHabitaciones(3);
		casa.setNumBaños(2);

		Stream stream2 = new Stream(casa);

		Funcion funcion = new Funcion();

		Integer numHabitacionesStream1 = stream1.map(funcion);
		Integer numHabitacionesStream2 = stream2.map(funcion);
		System.out.println("numHabitacionesStream1:" + numHabitacionesStream1);
		System.out.println("numHabitacionesStream2:" + numHabitacionesStream2);
		System.out.println("-----------------------------");

		IFuncion funcion2 = new Funcion();

		numHabitacionesStream1 = stream1.map(funcion2);
		numHabitacionesStream2 = stream2.map(funcion2);
		System.out.println("numHabitacionesStream1:" + numHabitacionesStream1);
		System.out.println("numHabitacionesStream2:" + numHabitacionesStream2);
		System.out.println("-----------------------------");

		IFuncion funcion3 = new IFuncion() {
			public Integer apply(Casa casa) {

				return casa.getNumHabitaciones();
			}

		};

		numHabitacionesStream1 = stream1.map(funcion3);
		numHabitacionesStream2 = stream2.map(funcion3);
		System.out.println("numHabitacionesStream1:" + numHabitacionesStream1);
		System.out.println("numHabitacionesStream2:" + numHabitacionesStream2);
		System.out.println("-----------------------------");

		IFuncion funcion4 = (a) -> a.getNumHabitaciones();

		numHabitacionesStream1 = stream1.map(funcion4);
		numHabitacionesStream2 = stream2.map(funcion4);
		System.out.println("numHabitacionesStream1:" + numHabitacionesStream1);
		System.out.println("numHabitacionesStream2:" + numHabitacionesStream2);
		System.out.println("-----------------------------");

		IFuncion funcion5 = (a) -> a.getNumBaños();

		Integer numBañosStream1 = stream1.map(funcion5);
		Integer numBañosStream2 = stream2.map(funcion5);
		System.out.println("numBañosStream1:" + numBañosStream1);
		System.out.println("numBañosStream2:" + numBañosStream2);
		System.out.println("-----------------------------");

		/*
		 * Utilizamos la interfaz funcional de Java
		 */
		List<Casa> casas = new ArrayList<Casa>();
		Casa casa1 = new Casa();
		casa1.setNumHabitaciones(3);
		casa1.setNumBaños(2);
		casa1.setNombre("Primera Casa");
		casas.add(casa1);
		Casa casa2 = new Casa();
		casa2.setNumHabitaciones(2);
		casa2.setNumBaños(1);
		casa2.setNombre("Segunda Casa");
		casas.add(casa2);
		Casa casa3 = new Casa();
		casa3.setNumHabitaciones(1);
		casa3.setNumBaños(1);
		casa3.setNombre("Tercera casa");
		casas.add(casa3);
		Casa casa4 = new Casa();
		casa4.setNumHabitaciones(10);
		casa4.setNumBaños(5);
		casa4.setNombre("Cuarta casa");
		casas.add(casa4);

		Function<Casa, Integer> funcion6 = (a) -> a.getNumHabitaciones();
		
		casas.stream().map(funcion6).forEach(System.out::print);
		System.out.println();
		
		System.out.println("-----------------------------");
		
		casas.stream().map(Casa::getNumHabitaciones).forEach(System.out::print);
		System.out.println();
		
		System.out.println("-----------------------------");

		casas.stream().map((a)-> a.getNumBaños()).forEach(System.out::print);
		System.out.println();
		
		System.out.println("-----------------------------");

		casas.stream().map(Casa::getNumBaños).forEach(System.out::print);
		System.out.println();
		
		System.out.println("-----------------------------");

		casas.stream().map((a)-> a.getNombre()).forEach(System.out::print);
		System.out.println();
		
		System.out.println("-----------------------------");

		casas.stream().map(Casa::getNombre).forEach(System.out::print);
		System.out.println();
		
		
		//Usamos unarios

		System.out.println("-----------------------------");
		//             Stream<Casa>            Stream<String>
		casas.stream().map((a)-> a.getNombre()).map((a)-> a.toUpperCase()).forEach(System.out::print);
		System.out.println();
		
		System.out.println("-----------------------------");

		casas.stream().map(Casa::getNombre).map(String::toUpperCase).forEach(System.out::print);
		System.out.println();

	}

}
