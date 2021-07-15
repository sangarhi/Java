package com.tipoLambda;

import java.util.function.Consumer;
import java.util.function.Supplier;

import com.tipoLambda.data.Casa;
import com.tipoLambda.interfaces.ISupplier;
import com.tipoLambda.ln.Proveedora;

public class TestProveedora {

	public static void main(String[] args) {
		
		Stream stream = new Stream();
		
		Proveedora proveedora = new Proveedora();
		
		Object objeto = stream.generate(proveedora);
		
		System.out.println(objeto);//Muestra 5 porque el objeto es un Integer
		System.out.println(((Integer)objeto));
		
		System.out.println("--------------------");
		
		ISupplier proveedora2 = new Proveedora();
		
		Object objeto2 = stream.generate(proveedora2);
		
		System.out.println(objeto2);//Muestra 5 porque el objeto es un Integer
		System.out.println(((Integer)objeto2));	
		
		System.out.println("--------------------");
		ISupplier proveedora3 = new ISupplier() {
			public Object get() {
				return "HOLA";
			}
		};
		
		Object objeto3 = stream.generate(proveedora3);
		
		System.out.println(objeto3);
		//System.out.println(((Integer)objeto3));	//Ahora no es un Integer
		
		System.out.println("--------------------");
		ISupplier proveedora4 = ()->"HOLA";
		
		Object objeto4 = stream.generate(proveedora4);
		
		System.out.println(objeto4);
		
		System.out.println("--------------------");
		ISupplier proveedora5 = ()-> new Integer(5);
		
		Object objeto5 = stream.generate(proveedora5);
		
		System.out.println(objeto5);
		
		System.out.println("--------------------");
		ISupplier proveedora6 = ()-> new Casa();
		
		Object objeto6 = stream.generate(proveedora6);
		
		System.out.println(objeto6);
		System.out.println("--------------------");
		
		/*
		 * Utilizando la interfaz funcional de Java
		 */
		System.out.println("-------UTILIZANDO LAS DE JAVA------------");

		Supplier<Casa> proveedora7= ()-> new Casa();
		Supplier<String> proveedora8 = () -> "HOLA";
		Supplier<Integer> proveedora9 = () -> new Integer(5);
		
		Consumer<Casa> consumidora = (a)-> System.out.println(a);
		
				
		 java.util.stream.Stream.generate(proveedora7)
		 						.limit(5)
		 						.forEach(consumidora);	
		 System.out.println("--------------------");
		 
		 java.util.stream.Stream.generate(()-> new Integer(5))
		 						.limit(3)
		 						.forEach((a)->System.out.println("Numero:"+a));
		
		 System.out.println("--------------------");
		 
		 Supplier<Casa> proveedora10= Casa::new;	    
			
		 Consumer<Casa> consumidora2 = System.out::println;
		 
		 java.util.stream.Stream.generate(proveedora10)
			.limit(5)
			.forEach(consumidora2);	
		
		 System.out.println("--------------------");
		 java.util.stream.Stream.generate(Casa::new)
			.limit(3)
			.forEach(System.out::println);	
		
	}

}
