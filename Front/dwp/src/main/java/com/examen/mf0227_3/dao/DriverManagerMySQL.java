package com.examen.mf0227_3.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverManagerMySQL {
	private static DriverManagerMySQL instancia;
	private DriverManagerMySQL() {;}
	public static DriverManagerMySQL getInstancia() {
		if(instancia == null) instancia = new DriverManagerMySQL();
		return instancia;
	}
	
	public Connection getConexion() {		
		String connectionString="jdbc:mysql://localhost:3307/examen?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		Connection con=null;
		try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		    } catch (ClassNotFoundException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		try {
		        con=DriverManager.getConnection(connectionString,"userJava","alumno");
		    } catch (SQLException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		return con;
	}

}
