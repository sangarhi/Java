package com.front.pTipoAnt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverManagerMySQL {

	private static DriverManagerMySQL instance;

	private DriverManagerMySQL() {
		super();

	}

	public static DriverManagerMySQL getInstance() {
		if (instance == null)
			instance = new DriverManagerMySQL();
		return instance;
	}

	public static Connection getConnexion() {
		String connectionString = "jdbc:mysql://localhost:3307/hr?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		Connection con = null;
		
		try {
			//Carga el driver en memoria
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(connectionString, "HR", "hr");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

}
