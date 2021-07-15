package ioProfe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestFileReaderWriterAvanzado {

	public static void main(String[] args) {

		try {

			// Creamos el archivo
			File file = new File("fichero2.txt");

			file.createNewFile();

			// Escribimos en el archivo

			FileWriter fw = new FileWriter(file);

			fw.write("Contenido del ficheroñññññññ\n");
			fw.write("Mas Contenido del fichero");

			fw.flush();
			// Estamos cerrandolo mal, debería ser con finally
			fw.close();

			File file2 = new File("fichero.txt");
			
			//SIN TENER EN CUENTA EL CHARSET
			FileReader fr = new FileReader(file2);
			BufferedReader reader = new BufferedReader(fr);			
			
			
			System.out.println("LEEEMOS FICHERO CON EL CHARSET DEL SISTEMA");
			System.out.println("Ecoding:"+ fr.getEncoding());
			String cadena = reader.readLine();			
			while (cadena!=null) {
				System.out.println(cadena);
				cadena = reader.readLine();
			}
			System.out.println("-----------------------------------");
			

			
			// Estamos cerrandolo mal, debería ser con finally
			fr.close();
			reader.close();
			
			//TENIENDO EN CUENTA EL CHARSET
			
			
			FileInputStream fis = new FileInputStream(file2);
			InputStreamReader isr = new InputStreamReader(fis,"ISO-8859-1");
			BufferedReader reader2 = new BufferedReader(isr);

			System.out.println("LEEEMOS FICHERO CON EL CHARSET DEL ISO-8859-1");
			String cadena2 = reader2.readLine();			
			while (cadena2!=null) {
				System.out.println(cadena2);
				cadena2 = reader2.readLine();
			}
			System.out.println("-----------------------------------");
			
			// Esto lo veremos con las lambda
			//reader2.lines().forEach(System.out::println);
			System.out.println("-----------------------------------");
			
			fis.close();
			isr.close();
			reader2.close();

		} catch (FileNotFoundException fne) {
			System.err.println("El fichero no existe");
		} catch (IOException e) {
			System.err.println("Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Exception general");
			e.printStackTrace();
		}

	}

}
