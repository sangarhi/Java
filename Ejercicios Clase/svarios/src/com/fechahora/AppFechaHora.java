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

		System.out.println("Departure date: " + departureDate);
		System.out.println("Arrival in México time: " + departureDate.plusHours(12));
		System.out.println("Arrival in Amsterdam time: "
				+ ZonedDateTime.ofInstant(departureDate.plusHours(12).toInstant(), zoneIdAm));

		// Paso 1. Hora de salida y llegada (planificada y real) de un vuelo de Japon a Madrid que tarda 15
		// horas. Hora de salida en Japon: 23/04/2019 06:20

		ZoneId zonaJapon = ZoneId.of("Japan");
		ZoneId zonaMadrid = ZoneId.of("Europe/Paris");
		LocalDateTime horaSalidaServidor= LocalDateTime.of(2019, Month.APRIL, 23, 06, 20);
		ZonedDateTime horaSalidaJapon = ZonedDateTime.of(2019, 04, 23, 2, 06, 20, 0, zonaJapon);
		ZonedDateTime horaSalidaMadrid = ZonedDateTime.of(horaSalidaServidor, zonaMadrid);
		
		LocalDateTime horaLlegadaServidor= horaSalidaServidor.plusHours(15);
		ZonedDateTime horaLlegadaJapon = ZonedDateTime.of(horaLlegadaServidor, zonaJapon);
		ZonedDateTime horaLLegadaMadrid = ZonedDateTime.ofInstant(horaLlegadaJapon.toInstant(), zonaMadrid);
		

		
		
		System.out.println("Hora salida en Japon: " + horaSalidaJapon);
		System.out.println("Hora salida en Madrid: " + horaSalidaMadrid);
		System.out.println("Hora de Llegada en Japon : " + horaLlegadaJapon);
		System.out.println("Hora de Llegada en Madrid: "+ horaLLegadaMadrid);
				

	}

}
