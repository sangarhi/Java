package ioProfe;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class TestPrintStream {

	public static void main(String[] args) {
		//El par�metro boolean cuando abro FileOutputStream
		//indica si a�ado el texto (true) o lo sobreescribo(false)
		try(FileOutputStream  fos = new FileOutputStream("texto.txt",Boolean.TRUE);
		PrintStream ps = new PrintStream(fos);){
			
			ps.println("Ahora a�ado");
			ps.println("Otro mas");
			System.out.println("Hemos a�adido contenido al archivo");
			
		} catch (FileNotFoundException fne) {
			System.err.println("El fichero no existe");
		} catch (IOException e) {
			System.err.println("Error de entrada/salida");
			e.printStackTrace();
		}catch(Exception e) {
			System.err.println("Exception general");
			e.printStackTrace();
		}
		
	}

}
