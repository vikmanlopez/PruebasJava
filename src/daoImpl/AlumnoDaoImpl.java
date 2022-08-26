package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import coneccion.Coneccion;
import dao.AlumnoDao;
import modelo.Alumno;

public class AlumnoDaoImpl implements AlumnoDao{

	@Override
	public int insertar(Alumno obj) {
		String sql="INSERT INTO alumno(nombre, apellido, identificador, fechaNac) VALUES (?,?,?,?)";
		
		Connection con = null;
		PreparedStatement pstm = null;
		int resultado = 0;
		
		con = Coneccion.conectar();
		
	    try {
			pstm = con.prepareStatement(sql);
			//parametros
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getApellido());
			pstm.setString(3, obj.getIdentificador());
			pstm.setDate(4, new java.sql.Date(obj.getFechaNac().getTime()));
			
			
			resultado = pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al ejecutar query de insert : "+ e.getMessage());
		}
		
		return resultado;
	}

	@Override
	public int modificar(Alumno obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminar(Alumno obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Alumno> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno obtenerPorIdentificacion(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
