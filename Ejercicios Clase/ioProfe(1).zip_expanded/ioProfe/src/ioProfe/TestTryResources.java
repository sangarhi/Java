package ioProfe;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestTryResources {

	public static void main(String[] args) {

		try (FileOutputStream fos = new FileOutputStream("texto.txt");
				DataOutputStream dos = new DataOutputStream(fos);) {

			dos.writeUTF("Mi Cadena");

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
