package com.excepciones.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestBuffer2 {

	public static void main(String[] args) {

		BufferedReader br=null;
		try {
			br = new BufferedReader(new FileReader("texto.txt"));
			System.out.println(br.readLine());
			
		} catch (IOException ioe) {
			System.out.println("Excepcion de lectura");			
			ioe.printStackTrace();
		} finally {
			System.out.println("Finally");
			try {
				br.close();
			} catch (IOException e) {
				System.out.println("Excepcion en el finally");
				e.printStackTrace();
			}
		}
	}

}
