package com.tipoLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.tipoLambda.data.Casa;

public class Test {

	public static void main(String[] args) {
		List<Casa> casas = new ArrayList<Casa>();
		Casa casa1 = new Casa();
		casa1.setNumHabitaciones(3);
		casa1.setNumBa�os(2);
		casa1.setNombre("Primera Casa");
		casas.add(casa1);
		Casa casa2 = new Casa();
		casa2.setNumHabitaciones(2);
		casa2.setNumBa�os(1);
		casa2.setNombre("Segunda Casa");
		casas.add(casa2);
		Casa casa3 = new Casa();
		casa3.setNumHabitaciones(1);
		casa3.setNumBa�os(1);
		casa3.setNombre("Tercera casa");
		casas.add(casa3);
		Casa casa4 = new Casa();
		casa4.setNumHabitaciones(10);
		casa4.setNumBa�os(5);
		casa4.setNombre("Cuarta casa");
		casas.add(casa4);
		
		//�Cuantas casas tienen mas de 2 cuartos de ba�o
		long numCasas = casas.stream().mapToInt(Casa::getNumBa�os).filter((a)->a>2).count();

		System.out.println("�Cuantas casas tienen mas de 2 cuartos de ba�o?:"+numCasas);
		
		//�Cuantos cuartos de ba�o hay en total?
		
		//Tres opciones:
		
		//int numBa�osTotal= casas.stream().map(Casa::getNumBa�os).reduce(0,Integer::sum);
		//int numBa�osTotal= casas.stream()
		//						.map(Casa::getNumBa�os)
		//						.reduce(0,(acumulador,elemento)->acumulador+elemento);
		
		int numBa�osTotal = casas.stream()
				.map(Casa::getNumBa�os).mapToInt(Integer::intValue).sum();

		System.out.println("�Cuantos cuartos de ba�o hay en total? "+numBa�osTotal);
		
		
		 String[] cadenas2 = {"MESA","CASA","SILLA","ORDENADOR","SILLA"};
		 
		 Arrays.stream(cadenas2).distinct().forEach(System.out::println);
		 
		 long numElementos = Arrays.stream(cadenas2)
				 				.distinct()
				 				.peek(System.out::println)
				 				.count();
		 
		 System.out.println("Numero de elementos no repetidos:"+numElementos);
		 
		 System.out.println("--------------- Contiene i en nombre --------------------------");
		 // Sacar las casas que contengan una "i" en su nombre
		 casas.stream().filter((a) -> a.getNombre().contains("i")).forEach(System.out::println);
		 
		 System.out.println("--------------- Contiene a en nombre --------------------------");
		// Sacar las casas que contengan una "i" en su nombre
		 casas.stream().filter(a -> a.getNombre().contains("a")).forEach(System.out::println);
		 
		 List<Casa> casas2 = casas.stream().filter(a -> a.getNombre().contains("e")).collect(Collectors.toList());
		 
		 
		 System.out.println("--------- Listado ordenado, sin duplicados y con s ------------");
		 // Sacar un listado ordenado de cadena2 donde no existan duplicados y que tengan una s
		 
		// List<String> cadenas3 = Arrays.stream(cadenas2).map(s -> s.toLowerCase()).distinct().filter(s -> s.contains("s")).collect(Collectors.toList()); Equivalente a lo de abajo
		 //El map se utiliza cuando quieres cambiar algo en el objeto (de mayusculas a minusculas...etc), o cambiar el tipo
		 List<String> cadenas3 = Arrays.stream(cadenas2)
				 						.map(String::toLowerCase)
				 						.distinct()
				 						.filter(s -> s.contains("s"))
				 						.sorted()
				 						.peek(System.out::println)
				 						.collect(Collectors.toList()); //collect es para cambiarlo a lista
		 
	}

}
