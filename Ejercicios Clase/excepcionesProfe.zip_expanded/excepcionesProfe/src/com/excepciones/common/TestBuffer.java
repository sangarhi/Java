package com.excepciones.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestBuffer {

	public static void main(String[] args) {

		try(BufferedReader br=new BufferedReader(new FileReader("texto.txt"));) {
			
			System.out.println(br.readLine());
			
		} catch (IOException ioe) {
			System.out.println("Excepcion de lectura");			
			ioe.printStackTrace();
		} 
		
	}

}
