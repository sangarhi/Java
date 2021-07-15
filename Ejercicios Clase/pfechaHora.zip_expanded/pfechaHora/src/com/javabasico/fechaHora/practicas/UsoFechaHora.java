package com.javabasico.fechaHora.practicas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class UsoFechaHora {

	public static void main(String[] args) {
		//La fecha de ahora mismo
		System.out.println(LocalDate.now());
		
		System.out.println("-----------------Abraham Lincoln--------------");
		//El nacimiento de Abraham Lincoln: February 12, 1809, murio April 15, 1855
		LocalDate nacimiento = LocalDate.of(1809, Month.FEBRUARY, 12);
		LocalDate muerte = LocalDate.of(1855, Month.APRIL, 15);
		//   ¿Con qué edad murio?
		Period periodo = Period.between(nacimiento, muerte);
		System.out.println("Edad en la que fue asesinado: " + periodo.getYears());
	    //   ¿Cuántos dias vivio?
		//periodo.get(ChronoUnit.DAYS);
		System.out.println("Días que vivió: " + ChronoUnit.DAYS.between(nacimiento, muerte));
		
		//Duration duracion = Duration.between(nacimiento, muerte);
		
		System.out.println(periodo);
		// Convertir fecha de nacimiento a java.util.Date  
		 Date date = new Date();
		  

		System.out.println("-----------------Bennedict Cumberbatch--------------");
	    
	    // Bennedict Cumberbatch nacio en: July 19, 1976
		LocalDate nacimientoBC = LocalDate.of(1976, Month.JULY, 19);
	    //   ¿Nació en año bisiesto?
		System.out.println("Año bisiesto: " + nacimientoBC.isLeapYear());
	    //   ¿Cuantas decadas tiene?
		System.out.println("Las décadas que tiene son: " + ChronoUnit.DECADES.between(nacimientoBC, LocalDate.now()));
	    //   ¿Cuál fue el dia de la semana de su 21 cumpleaños?	
		System.out.println("El día de la semana de su 21 cumpleaños fue: " + nacimientoBC.plusYears(21).getDayOfWeek());
		   
	    
		System.out.println("-----------------Tren Boston - NYC--------------");
	    // Un tren sale de Boston a la 1:45PM y llega New York 7:25PM
	    //   ¿Cuantos minutos a tardado?
		LocalTime boston = LocalTime.of(1, 45);
		LocalTime nyc = LocalTime.of(7, 25);
		System.out.println("Los minutos que ha tardado han sido: " + ChronoUnit.MINUTES.between(boston, nyc));
	    //   Si el tren tiene un retraso de 1 hora y 19 minutos, ¿Cual es la hora final de llegada?
		  System.out.println("La hora final serían las: " + nyc.plusHours(1).plusMinutes(19));
		 
		  System.out.println("-----------------Vuelo a Miami--------------");
	    // Vuelo: De Boston a Miami, sale el 14 de Marzo a las 9:15PM. Tiempo de vuelo 4 horas 15 minutos
	    //   ¿Cuando llega a Miami?
		  LocalDateTime fecha = LocalDateTime.of(2021, 3, 14, 21, 15);
		  LocalDateTime llegadaVuelo = fecha.plusHours(4).plusMinutes(15);
		  System.out.println(llegadaVuelo);
	    //   ¿Cuando llega si se retrasa 4 horas 27 minutos?
		  LocalDateTime llegadaRetraso = llegadaVuelo.plusHours(4).plusMinutes(27);
		 System.out.println(llegadaRetraso);
	   

	}

}
