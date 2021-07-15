package com.tipoLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.tipoLambda.data.Casa;
import com.tipoLambda.interfaces.IFiltro;
import com.tipoLambda.ln.Filtro;

public class TestFiltro {

	public static void main(String[] args) {
		
	   Stream stream = new Stream("HOLA");
	   Stream stream2 = new Stream();
	   
	   Filtro filtro = new Filtro();
	   
	   boolean valor = stream.filter(filtro);	   
	   System.out.println("Valor stream con 'HOLA':"+valor);
	   
	   boolean valor2 = stream2.filter(filtro);	   
	   System.out.println("Valor stream con cadena nula:"+valor2);
	   System.out.println("-----------------");
	   
	   IFiltro filtro2 = new Filtro();
	   
	    valor = stream.filter(filtro2);	   
	   System.out.println("Valor stream con 'HOLA':"+valor);
	   
	    valor2 = stream2.filter(filtro2);	   
	   System.out.println("Valor stream con cadena nula:"+valor2);
	   System.out.println("-----------------");
	   
	   IFiltro filtro3 = new IFiltro() {
		   @Override
			public boolean test(Object o) {
				//Comprobamos  si la cadena es nula o vacía
				return (o==null || ((String)o).length()==0);
			}
	   };
	   
	    valor = stream.filter(filtro3);	   
	   System.out.println("Valor stream con 'HOLA':"+valor);
	   
	    valor2 = stream2.filter(filtro3);	   
	   System.out.println("Valor stream con cadena nula:"+valor2);
	   System.out.println("-----------------");
	   

	   
	   IFiltro filtro4 = new IFiltro() {
		   @Override
			public boolean test(Object o) {
				//Comprobamos  si la cadena es nula o mayor que quince
				return (o==null || ((String)o).length()>15);
			}
	   };
	   
	    valor = stream.filter(filtro4);	   
	   System.out.println("Valor stream con 'HOLA':"+valor);
	   
	    valor2 = stream2.filter(filtro4);	   
	   System.out.println("Valor stream con cadena nula:"+valor2);
	   System.out.println("-----------------");
	   
	   IFiltro filtro5 = (o) -> (o==null || ((String)o).length()>15);
	   
	    valor = stream.filter(filtro5);	   
	   System.out.println("Valor stream con 'HOLA':"+valor);
	   
	    valor2 = stream2.filter(filtro5);	   
	   System.out.println("Valor stream con cadena nula:"+valor2);
	   System.out.println("-----------------");
	   
	   /*
	    * Utilizamos la de Java 
	    */
	   
	   Predicate<String> filtro6 =  (o) -> (o==null || ((String)o).length()==0);
	   
	   String hola=null;
	   
	   String[] palabras = {"HOLA","","SILLA",hola,"MESA"};
	   
	   Arrays.stream(palabras).filter(filtro6).forEach(System.out::println);
	   System.out.println("-----------------");
	   
	   String[] palabras2 = {"HOLA","ORDENADOR","SILLA","","MESA"};
	   
	   Predicate<String> filtro7 = (a) ->a.contains("O");
	   
	   Arrays.stream(palabras2).filter(filtro7).forEach(System.out::println);
	   
	   System.out.println("-----------------");
	   
	   String cadena ="ORDENADOR";
	   
	   Predicate<String> filtro8 = (a) ->a.equals(cadena);
	   
	   Arrays.stream(palabras2).filter(filtro8).forEach(System.out::println);
	   
	   System.out.println("-----------------");
	   
	   List<Casa> casas = new ArrayList<Casa>();
	   Casa casa = new Casa();
	   casa.setNumHabitaciones(3);
	   casas.add(casa);
	   Casa casa2 = new Casa();
	   casa2.setNumHabitaciones(2);
	   casas.add(casa2);
	   Casa casa3 = new Casa();
	   casa3.setNumHabitaciones(1);
	   casas.add(casa3);
	   Casa casa4 = new Casa();
	   casas.add(casa4);
	   
	   Predicate<Casa> filtro9= (a)-> a.getNumHabitaciones()>1;
	   
	   casas.stream().filter(filtro9).forEach(System.out::println);
	   
	   System.out.println("-----------------");
	   

		

	}

}
