package ioProfe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class TestFileReaderWriter {

	public static void main(String[] args) {

		try {

			// Creamos el archivo
			File file = new File("fichero2.txt");
			file.createNewFile();

			// Escribimos en el archivo

			FileWriter fw = new FileWriter(file);

			fw.write("Contenido del fichero\n");
			fw.write("Mas Contenido del fichero");

			fw.flush();
			// Estamos cerrandolo mal, debería ser con finally
			fw.close();

			File file2 = new File("fichero.txt");

			FileReader fr = new FileReader(file2);

			char[] a = new char[50];
			int i = fr.read(a);

			while (i != -1) {
				
				//for (char c : a)
				//	System.out.print(c);
				System.out.println("/"+String.valueOf(a)+"/");
				Arrays.fill(a, '\u0000');				
				i = fr.read(a);
				System.out.println("Caracteres leidos:"+i);
			}
			
			// Estamos cerrandolo mal, debería ser con finally
			fr.close();

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
