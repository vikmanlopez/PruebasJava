package coneccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Coneccion {
	
	public static Connection conectar() {
		Connection con = null;
		
		String jdbc = "jdbc:mysql://localhost:3306/test";
		String user = "";
		String pass = "";
		
		try {
			con = DriverManager.getConnection(jdbc, user, pass);
		} catch (SQLException e) {
			System.out.println("Error al crear coneccion: "+ e.getMessage());
		}
		return con;
	}
}
