package ioProfe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class TestFileScanner {

	public static void main(String[] args) {

		try {

			// Creamos el archivo
			File file = new File("fichero.txt");
			
			Scanner sc = new Scanner(file);
			System.out.println(sc.nextLine());			
			
			
			
			sc.close();

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
