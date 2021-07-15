package com.proyecto.common.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

public class FileHelper {

	public static final String TAG = FileHelper.class.getName();

	private static final Logger log = Logger.getLogger(FileHelper.class);

	public static void writeLines(Path path, List<String> lines) throws IOException {
		log.debug("[Writing]");
		Files.write(path, lines);
	}

	public static ArrayList<String> readLines(Path path) throws IOException {
		log.debug("[Reading]");
		Stream<String> lineas = Files.lines(path);
		ArrayList<String> filas = (ArrayList<String>) lineas.collect(Collectors.toList());
		lineas.close();

		return filas;

	}

}
