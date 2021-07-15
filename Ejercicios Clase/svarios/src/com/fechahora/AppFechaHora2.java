package com.fechahora;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Set;

public class AppFechaHora2 {
	public static void main(String[] args) {
		// Mostramos todas las zonas horarias
		Set<String> zonas = ZoneId.getAvailableZoneIds();
		zonas.stream().sorted().forEach(System.out::println);

		// Salida de un vuelo de Mexico a Amsterdam
		ZoneId zoneIdMx = ZoneId.of("America/Mexico_City");
		ZoneId zoneIdAm = ZoneId.of("Europe/Amsterdam");
		ZonedDateTime departureDate = ZonedDateTime.of(2018, 10, 31, 2, 39, 0, 0, zoneIdMx);
		
		LocalDateTime fecha =LocalDateTime.of(2018,Month.OCTOBER,31,2,39,0);
		ZonedDateTime departureDate2 = ZonedDateTime.of(fecha,zoneIdMx);
		ZonedDateTime departureDateAmsterdm = ZonedDateTime.of(fecha,zoneIdAm);
		
		ZonedDateTime arrivalDateMx= departureDate2.plusHours(12);
		
		ZonedDateTime arrivalDateAms= departureDateAmsterdm.plusHours(12);
		

		System.out.println("Departure date: " + departureDate);
		System.out.println("Arrival in México time: " + departureDate.plusHours(12));
		System.out.println("Arrival in Amsterdam time: "
				+ ZonedDateTime.ofInstant(departureDate.plusHours(12).toInstant(), zoneIdAm));

		// Paso 1. Hora de salida y llegada (planificada y real) de un vuelo de Japon a Madrid que tarda 15
		// horas. Hora de salida en Japon: 23/04/2019 06:20
		
		System.out.println(ZoneId.systemDefault());
		
		ZoneId zonaJapon = ZoneId.of("Japan");
		ZoneId zonaMadrid = ZoneId.of("Europe/Madrid");

		LocalDateTime fechaSalida = LocalDateTime.of(2019,Month.APRIL,23,06,20,0);
		
		ZonedDateTime fechaSalidaJapon= ZonedDateTime.of(fechaSalida, zonaJapon);
		ZonedDateTime fechaSalidaMadrid = ZonedDateTime.ofInstant(fechaSalidaJapon.toInstant(), zonaMadrid);
		
		System.out.println("FechaSalida:"+ fechaSalida);
		System.out.println("fechaSalidaJapon:"+ fechaSalidaJapon);
		System.out.println("fechaSalidaMadrid:"+ fechaSalidaMadrid);
		
		ZonedDateTime fechaLlegadaJapon = fechaSalidaJapon.plusHours(15);
		ZonedDateTime fechaLlegadaMadrid = fechaSalidaMadrid.plusHours(15);
		ZonedDateTime fechaLLegadaMadrid2 = ZonedDateTime.ofInstant(fechaLlegadaJapon.toInstant(), zonaMadrid);
		
		LocalDateTime fechaLlegadaJapon2 = fechaSalida.plusHours(15);
		
		
		
		ZonedDateTime fechaLLegadaMadrid3 = fechaLlegadaJapon.withZoneSameInstant(zonaMadrid);
		
		
		System.out.println("fechaLlegadaJapon:"+ fechaLlegadaJapon);
		System.out.println("fechaLlegadaMadrid:"+ fechaLlegadaMadrid);
		System.out.println("fechaLlegadaMadrid2:"+ fechaLLegadaMadrid2);
		System.out.println("fechaLLegadaMadrid3:"+ fechaLLegadaMadrid3);
		
		//Ejemplo ZoneOffset y OffsetDateTime
		
		LocalDateTime now = LocalDateTime.now();
		ZoneId zone = ZoneId.of("Japan");
		ZoneOffset zoneOffSet = zone.getRules().getOffset(now);
		OffsetDateTime fechaOffset = OffsetDateTime.now(zoneOffSet);
		System.out.println("now:"+ now);
		System.out.println("zoneOffSet:"+ zoneOffSet);
		System.out.println("fecha:"+ fechaOffset);
		


		
	
		
				

	}

}
