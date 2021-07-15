package ioProfe;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TestNIO2 {

	public static void main(String[] args) throws IOException{
		//PATH clase de NIO2
		Path pathFile = Paths.get("fichero.txt");		
		System.out.println("Path: "+ pathFile);
		
		//FILES clase de NIO2
		Charset charset = Charset.forName("ISO-8859-1");
		BufferedReader reader = Files.newBufferedReader(pathFile,charset);
		
		String cadena = reader.readLine();			
		while (cadena!=null) {
			System.out.println(cadena);
			cadena = reader.readLine();
		}
		
		System.out.println("---------------------------------");
		//Uso de Files
		
		//Copia de archivo
		Path pathFicheroCopia = Paths.get("ficheroCopia.txt");
		
		Files.copy(pathFile, pathFicheroCopia, StandardCopyOption.REPLACE_EXISTING);
		//mover un archivo a una carpeta previamente creada
		Files.createDirectories(Paths.get("miCarpeta"));
		Files.move(pathFicheroCopia, Paths.get("miCarpeta/fichero.txt"),StandardCopyOption.REPLACE_EXISTING);
		
		//FileSystem
		System.out.println("---------DIRECTORIOS-----------------------");
		FileSystem fs = FileSystems.getDefault();
		
		for( Path path :fs.getRootDirectories()) {
			System.out.println(path);			
		}
		
		
		System.out.println("------------Uso de lambdas--------------------");

		
		Files.lines(pathFile).forEach(System.out::println);
		
		
		
		
		

	}

}
