package me.thiagoAfonso.SGRH.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
	private static Connection conn = null;

	public static Connection getConexao() throws ClassNotFoundException, SQLException {

		String driverName = "com.mysql.jdbc.Driver";
		Class.forName(driverName);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
		System.out.println("Conectado!");
		return conn;
	}
}