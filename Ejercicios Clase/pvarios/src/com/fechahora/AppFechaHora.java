package com.fechahora;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class AppFechaHora {
	public static void main(String[] args) {
		// Mostramos todas las zonas horarias
		Set<String> zonas = ZoneId.getAvailableZoneIds();

		zonas.stream().sorted().forEach(System.out::println);

		// Salida de un vuelo de Mexico a Amsterdam
		ZoneId zoneIdMx = ZoneId.of("America/Mexico_City");
		ZoneId zoneIdAm = ZoneId.of("Europe/Amsterdam");
		ZonedDateTime departureDate = ZonedDateTime.of(2018, 10, 31, 2, 39, 0, 0, zoneIdMx);

		System.out.println("--------------------------- MEXICO - AMSTERDAM ---------------------------");
		LocalDateTime fecha = LocalDateTime.of(2018, Month.OCTOBER, 31, 2, 39, 0);
		ZonedDateTime departureDate2 = ZonedDateTime.of(fecha, zoneIdMx);
		ZonedDateTime departureDateAmsterdam = ZonedDateTime.of(fecha, zoneIdAm);

		ZonedDateTime arrivalDateMx = departureDate2.plusHours(12);
		ZonedDateTime arrivalDateAm = departureDateAmsterdam.plusHours(12);

		System.out.println("Departure date: " + departureDate);
		System.out.println("Arrival in México time: " + departureDate.plusHours(12));
		System.out.println("Arrival in Amsterdam time: "
				+ ZonedDateTime.ofInstant(departureDate.plusHours(12).toInstant(), zoneIdAm));

		System.out.println("--------------------------- JAPAN - MADRID ---------------------------");
		// Paso 1. Hora de salida y llegada (planificada y real) de un vuelo de Japon a
		// Madrid que tarda 15
		// horas. Hora de salida en Japon: 23/04/2019 06:20
		ZoneId zoneIdJap = ZoneId.of("Japan");
		ZoneId zoneIdMad = ZoneId.of("Europe/Madrid");

		LocalDateTime fechaSalida = LocalDateTime.of(2019, Month.APRIL, 23, 006, 20, 0);

		ZonedDateTime fechaSalidaJap = ZonedDateTime.of(fechaSalida, zoneIdJap);
		ZonedDateTime fechaSalidaMad = ZonedDateTime.ofInstant(fechaSalidaJap.toInstant(), zoneIdMad);

		System.out.println("Departure date: " + fechaSalida);
		System.out.println("Departure in Japan time: " + fechaSalidaJap);
		System.out.println("Departure in Madrid time: " + fechaSalidaMad);
		
		System.out.println("--------------------------------------------------------------");
		
		ZonedDateTime departureJap = ZonedDateTime.of(2019, 4, 23, 6, 20, 0, 0, zoneIdJap);

		System.out.println("Departure date: " + departureJap);
		System.out.println("Arrival in Japan time: " + departureJap.plusHours(15));
		System.out.println("Arrival in Madrid time: "
				+ ZonedDateTime.ofInstant(departureJap.plusHours(15).toInstant(), zoneIdMad));

		

	}

}
