package com.javabasico.fechahora;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FechaHora {

	public static void main(String[] args) {
		
        //Generar fechas/tiempos actuales
		
		LocalDate fechaAhora = LocalDate.now();
		System.out.println(fechaAhora);
		
		fechaAhora = fechaAhora.plusDays(10000);
		System.out.println(fechaAhora);
		System.out.println(fechaAhora.getDayOfWeek());
		System.out.println("Anio bisiesto:"+fechaAhora.isLeapYear());
		
		LocalTime tiempoAhora = LocalTime.now();
		System.out.println(tiempoAhora);
		
		LocalDateTime ahora = LocalDateTime.of(fechaAhora, tiempoAhora);
		LocalDateTime ahora2 = LocalDateTime.now();
		System.out.println(ahora);
		System.out.println(ahora2);
		
		Period periodo = Period.between(LocalDate.now(), fechaAhora);
		System.out.println("Periodo:"+periodo);
		
		Duration duration = Duration.between(ahora, ahora.plusMinutes(970));
		System.out.println("Duration:"+duration);
		
		System.out.println("------------------------------------------");
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now());
		
	

		

		LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
		LocalDate date2 = LocalDate.of(2015, 1, 20);
		
		

		LocalTime time1 = LocalTime.of(6, 15); // hour and minute LocalTime time2 =
		LocalTime.of(6, 15, 30); // + seconds
		LocalTime time3 = LocalTime.of(6, 15, 30, 200); // + nanoseconds

		

		LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 15, 30);
		LocalDateTime dateTime2 = LocalDateTime.of(date1, time1);

		

		LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
		LocalDate end = LocalDate.of(2015, Month.MARCH, 30);
		// performAnimalEnrichment(start, end);

		

		LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
		System.out.println(date.getDayOfWeek()); // MONDAY
		System.out.println(date.getMonth()); // JANUARY
		System.out.println(date.getYear()); // 2020
		System.out.println(date.getDayOfYear()); // 20

		LocalDate date25 = LocalDate.of(2020, Month.JANUARY, 20);
		LocalTime time25 = LocalTime.of(11, 12, 34);
		LocalDateTime dateTime25 = LocalDateTime.of(date, time25);
		System.out.println(date25.format(DateTimeFormatter.ISO_LOCAL_DATE));
		System.out.println(time25.format(DateTimeFormatter.ISO_LOCAL_TIME));
		System.out.println(dateTime25.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

		DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println(shortDateTime.format(dateTime25)); // 1/20/20
		System.out.println(shortDateTime.format(date)); // 1/20/20
		//System.out.println(shortDateTime.format(time25)); // UnsupportedTemporalTypeException

		DateTimeFormatter shortDateTime51 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println(dateTime25.format(shortDateTime));
		System.out.println(date.format(shortDateTime));
		//System.out.println(time25.format(shortDateTime));

		LocalDate date43 = LocalDate.of(2020, Month.JANUARY, 20);
		LocalTime time43 = LocalTime.of(11, 12, 34);
		LocalDateTime dateTime43 = LocalDateTime.of(date, time43);
		DateTimeFormatter shortF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		DateTimeFormatter mediumF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		System.out.println(shortF.format(dateTime43)); // 1/20/20 11:12 AM
		System.out.println(mediumF.format(dateTime43)); // Jan 20, 2020 11:12:34 AM

		DateTimeFormatter f = DateTimeFormatter.ofPattern("MM dd yyyy");
		LocalDate date44 = LocalDate.parse("01 02 2015", f);
		LocalTime time44 = LocalTime.parse("11:22");
		System.out.println(date44); // 2015-01-02
		System.out.println(time44); // 11:22

	}

}
