import java.sql.Connection;

import coneccion.Coneccion;

public class Pruebas {

	public static void main(String[] args) {
	
		System.out.println("Hola mundo");
		Connection con = null;
		
		con = Coneccion.conectar();
		System.out.println("Conectado a la BD");
		Coneccion.desconectar(con);
		System.out.println("Desconectado de la BD");
		
	}

}
