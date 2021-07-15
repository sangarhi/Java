package com.proyecto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.proyecto.dao.DepartamentoDAO;
import com.proyecto.dao.exceptions.DAOException;
import com.proyecto.dao.interfaces.IDAO;
import com.proyecto.data.Departamento;
import com.proyecto.ln.ServDepartamentos;
import com.proyecto.ln.exceptions.ServicioException;

public class App {
	
	private static final Logger log = Logger.getLogger(App.class);

	public static void main(String[] args) throws DAOException, IOException, ServicioException {
		
		// DIVIDIR CADENAS
		
		/*String cadena = "Google Apple Microsoft";
		String cadenaSinComas = cadena.replace(" ", ", ");
		System.out.println(cadenaSinComas);

		String cadena1 = "Google,Apple,Microsoft";
		String[] valores = cadena1.split(",");
		System.out.println(Arrays.toString(valores));*/
		
		// DAO
		
		/*IDAO<Departamento, Long> dao = new DepartamentoDAO();
		List<Departamento> departamentos = new ArrayList<Departamento>();
		try {
			departamentos = dao.findAll();
		} catch (DAOException e) {
			log.error(e.getTipoExcepcion().getMensaje());
		}
		departamentos.forEach(System.out::println);
		System.out.println("-----------------------------------");
		System.out.println(dao.findOne(200l));
		System.out.println("-----------------------------------");

		Departamento departamento = new Departamento();
		departamento.setId(280l);
		departamento.setNombre("MiDepartamento");
		departamento.setIdDireccion(1700l);

		System.out.println("Creación departamento");
		dao.create(departamento);

		try {
			departamentos = dao.findAll();
		} catch (DAOException e) {
			log.error(e.getTipoExcepcion().getMensaje());
		}
		departamentos.forEach(System.out::println);
		System.out.println("-----------------------------------");
		System.out.println("Actualización departamento");
		departamento.setNombre("Departamento_modificado");
		dao.update(departamento);

		try {
			departamentos = dao.findAll();
		} catch (DAOException e) {
			log.error(e.getTipoExcepcion().getMensaje());
		}
		departamentos.forEach(System.out::println);
		System.out.println("-----------------------------------");
		System.out.println("Borrado departamento");

		dao.delete(280l);

		try {
			departamentos = dao.findAll();
		} catch (DAOException e) {
			log.error(e.getTipoExcepcion().getMensaje());
		}
		departamentos.forEach(System.out::println);*/
		
		/*List<String> list = Arrays.asList("a", "b", "c");
		
		FileHelper.writeLines(Paths.get("probando.txt"), list);
		
		FileHelper.readLines(Paths.get("probando.txt"));*/
		
		/*String texto="nombre:pedro,nombre:gema,nombre:ana";
	    Stream<String> bloques= Pattern.compile(",").splitAsStream(texto);
	    bloques.map(cadena->cadena.substring(7, cadena.length())).
	    forEach(System.out::println);*/
		/*IDAO<Departamento, Long> dao = new DepartamentoDAO();
		List<Departamento> dptos = new ArrayList<Departamento>();
		List<String> lineas = new ArrayList<String>();
		try {
			dptos = dao.findAll();
		} catch (DAOException e) {
			log.error(e.getTipoExcepcion().getMensaje());
		}
		
		for (Departamento deps : dptos) {
			System.out.println(deps);
			lineas.add(deps.toString());
		}
		
		System.out.println(lineas);
		System.out.println("---------------------------");
		System.out.println(lineas.get(2));*/
		ServDepartamentos fichero = new ServDepartamentos();
		fichero.actualizarInformacion();
		fichero.generarFichero();
		//dptos.forEach(System.out::println);
		/*Departamento dpto = new Departamento();
		dpto.setId(1000l);
		dpto.setIdDireccion(500l);
		dpto.setIdManager(5l);
		dpto.setNombre("Shit");
		dptos.add(dpto);
		dao.findAll();*/
		//dptos.forEach(System.out::println);
		
		/*String dpStr = dptos.toString();
		System.out.println("String" + dpStr);
		
		System.out.println(dptos);*/
		
		/*List<String[]> csvData = createCsvDataSimple();

        // default all fields are enclosed in double quotes
        // default separator is a comma
        try (CSVWriter writer = new CSVWriter(new FileWriter("test.csv"))) {
            writer.writeAll(csvData);
        }

    }

    private static List<String[]> createCsvDataSimple() {
        String[] header = {"id", "name", "address", "phone"};
        String[] record1 = {"1", "first name", "address 1", "11111"};
        String[] record2 = {"2", "second name", "address 2", "22222"};

        List<String[]> list = new ArrayList<>();
        list.add(header);
        list.add(record1);
        list.add(record2);

        return list;*/
    }

	

}
