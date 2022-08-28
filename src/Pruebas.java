import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
		a.setNombre("Viktor");
		a.setApellido("Perez");
		a.setIdentificador("AA000");		
		a.setFechaNac(new Date());
		
		int resultado = 0;// dao.insertar(a);
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
			
	   // Pruba Listar alumnos
			List<Alumno> lst = new ArrayList<>();
			lst = dao.listar();
			for (int i = 0; i < lst.size() ;i++) {
				Alumno aa = lst.get(i);
				System.out.println(aa.toString()+"   fecha formateada: "+ aa.getFechaStr());
			}
				
			
		}
	}

}
