import java.sql.Connection;
import java.util.Date;

import coneccion.Coneccion;
import dao.AlumnoDao;
import daoImpl.AlumnoDaoImpl;
import modelo.Alumno;

public class Pruebas {

	public static void main(String[] args) {
	
		System.out.println("Hola mundo");
		// -- Prueba de coneccion------------------------
		Connection con = null;
		
		con = Coneccion.conectar();
		System.out.println("Conectado a la BD");
		Coneccion.desconectar(con);
		System.out.println("Desconectado de la BD");
		
		// --- Prueba de insercion-------------------------
		AlumnoDao dao = new AlumnoDaoImpl();
		
		Alumno a = new Alumno();
		a.setNombre("Juan");
		a.setApellido("Perez");
		a.setIdentificador("AA000");		
		a.setFechaNac(new Date());
		
		int resultado = dao.insertar(a);
		if(resultado == 1) {
			System.out.println("El alumno fue insertado exitosamente");
		}
	}

}
