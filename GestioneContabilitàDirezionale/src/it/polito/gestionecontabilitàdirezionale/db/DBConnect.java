package it.polito.gestionecontabilitàdirezionale.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnect {

	private static final String jdbcURL = "jdbc:mysql://localhost:3300/PRODUZIONE_TECNICI_2018?user=root";
	private static Connection connection;

	public static Connection getConnection() {
		if(connection == null) {
			try {
				connection = DriverManager.getConnection(jdbcURL);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connection;
	}
}

