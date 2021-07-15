package ioProfe;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestInicial {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {

			fos = new FileOutputStream("texto.txt");
			dos = new DataOutputStream(fos);
			dos.writeUTF("Mi Cadena");
			
			
		} catch (FileNotFoundException fne) {
			System.err.println("El fichero no existe");
		} catch (IOException e) {
			System.err.println("Error de entrada/salida");
			e.printStackTrace();
		}catch(Exception e) {
			System.err.println("Exception general");
			e.printStackTrace();
		}finally {
			try {
			dos.close();
			}catch(IOException io) {
				System.err.println("Error al cerrar DataOutputStream");
			}finally {
				try {
					fos.close();
				}catch (IOException io) {
					System.err.println("Error al cerrar FileOutputStream");
				}
			}
			
		}

		System.out.println("Llego aqui");

	}

}
