package ioProfe;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class TestBufferedReader {

	public static void main(String[] args) throws FileNotFoundException, IOException {

        String fileName = "fichero.txt";

        try (InputStream fis = new FileInputStream(fileName);
                InputStreamReader isr = new InputStreamReader(fis,
                        StandardCharsets.ISO_8859_1);
                BufferedReader br = new BufferedReader(isr)) {

            br.lines().forEach(line -> System.out.println(line));
        }

	}

}
