package com.product.mysqlHRmaven.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverManagerMySQL {
	private static DriverManagerMySQL instancia;

	private DriverManagerMySQL() {
		;
	}

	public static DriverManagerMySQL getInstancia() {
		if (instancia == null)
			instancia = new DriverManagerMySQL();
		return instancia;
	}

	public Connection getConexion() {
		String connectionString = "jdbc:mysql://localhost:3306/hr?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		Connection con = null;
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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

	/*
	 * public static void main(String[] args) {
	 * 
	 * DriverManagerOracle dm = DriverManagerOracle.getInstancia(); Connection con =
	 * dm.getConexion();
	 * 
	 * System.out.println(con);
	 * 
	 * }
	 */

}
