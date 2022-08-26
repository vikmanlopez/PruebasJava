package coneccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
	public static void desconectar(Connection con) {
		
			try {
				if(con != null) {
				con.close();
				}
			} catch (SQLException e) {
				System.out.println("Error al cerrar conección: " + e.getMessage());
			}
		
	}
	
	public static PreparedStatement preparedStatement(Connection con, String sql){
		PreparedStatement pstm = null;
		
		try {
			pstm = con.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println("Error al crear PreparedStatement: "+e.getMessage());
		}
		return pstm;
	}
	
	public static void cerrarPreparedStatement(PreparedStatement pstm) {
		
		try {
			if(pstm != null) {
			pstm.close();
			}
		} catch (SQLException e) {
			System.out.println("Error ala cerrar preparedStatement: "+e.getMessage());
		}
		
	}
	
}
