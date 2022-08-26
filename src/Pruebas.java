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
		
		int resultado = 0;//dao.insertar(a);
		if(resultado == 1) {
			System.out.println("El alumno fue insertado exitosamente");
		}
		// --- Prueba Actualizacion
		Alumno b = new Alumno();
		b.setNombre("Juan1");
		b.setApellido("Perez");
		b.setIdentificador("AA001");		
		b.setFechaNac(new Date());
		
		int resultadoU = dao.modificar(b);
		if(resultadoU == 1) {
			System.out.println("El alumno fue modificado exitosamente");
		}
	}

}
