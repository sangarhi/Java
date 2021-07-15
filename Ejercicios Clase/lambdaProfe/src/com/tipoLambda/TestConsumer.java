package com.tipoLambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import com.tipoLambda.interfaces.IConsumidora;
import com.tipoLambda.ln.Consumidora;

public class TestConsumer {

	public static void main(String[] args) {
		
		//Utilizo de cuerpo del método accept de la interfaz IConsumidora
		//implementado por clase concreta Consumidora	
		Consumidora consumidora = new Consumidora();
		Stream stream = new Stream("HOLA");
		stream.forEach(consumidora);
		
		//Sigo utilizando el cuerpo del método accept de la interfaz IConsumidora
		//implementado por clase concreta Consumidora
		IConsumidora consumidora2 = new Consumidora();
		stream.forEach(consumidora2);
		
		
		IConsumidora consumidora3 = new IConsumidora() {
			@Override
			public void accept(String cadena) {
				System.out.println(cadena+ " Interfaz anonima");

			}
	    };
	    stream.forEach(consumidora3);
	    
	    IConsumidora consumidora4 = (a)-> System.out.println(a+" Lambda");
	    stream.forEach(consumidora4);
	    
	    
	    /*
	     * A partir de aqui, utilizamos las clases JAVA
	     */
	    String[] cadenas = {"HOLA"};
	    List<String> cadenasListado = Arrays.asList(cadenas);
	    
	   
	    /* Ahora utilizamos la interfaz funcional de java CONSUMER
	     * 
	     */
	    
	    Consumer<String> consumer = (a)-> System.out.println(a+" Lambda usando stream()");
	    cadenasListado.stream().forEach(consumer);
	    System.out.println("------------------------------------");
	    String[] cadenas2 = {"MESA","CASA","SILLA","ORDENADOR","SILLA"};
	    List<String> cadenasListado2 = Arrays.asList(cadenas2);
	    
	    cadenasListado2.stream().forEach(consumer);
	    
	    cadenasListado2.stream().forEach((a)-> System.out.println("Mi palabra es: "+a));

	    
	    
	    
	    
	    
	    
	    
	    
	}

}
