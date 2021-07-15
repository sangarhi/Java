package ioProfe;

import java.io.File;
import java.io.IOException;

public class TestFile {

	public static void main(String[] args) {
		try {
			File file = new File("fichero.txt");
			System.out.println(file);
			System.out.println("Existe el fichero:"+(file.exists()?"si":"no"));
			System.out.println("Path absoluto:"+file.getAbsolutePath());
			System.out.println("Path canonical:"+file.getCanonicalPath());
			System.out.println("Es directorio:"+file.isDirectory());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
