package ioProfe;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestLectura {

	public static void main(String[] args) {

		try (FileInputStream fis = new FileInputStream("texto.txt");
				DataInputStream dis = new DataInputStream(fis);) {
			
			/* Modo antiguo de leer una cadena Opcion 1
			int i;			
			
			while((i=fis.read())!= -1) {
				System.out.print((char)i);
			}
			
			System.out.println();
			*/
			/*Modo antiguo de leer una cadena Opcion 2
			StringBuilder cadena = new StringBuilder();
			int i = fis.read();
			while(i != -1) {
				cadena.append((char)i);
				i = fis.read();				
			}
			System.out.println(cadena);
			*/
			

			String cadena= dis.readUTF();
			System.out.println(cadena);

		} catch (FileNotFoundException fne) {
			System.err.println("El fichero no existe");
		} catch (IOException e) {
			System.err.println("Error de entrada/salida");
			e.printStackTrace();
		}catch(Exception e) {
			System.err.println("Exception general");
			e.printStackTrace();
		}

		System.out.println("Llego aqui");

	}

}
