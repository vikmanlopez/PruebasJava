package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coneccion.Coneccion;
import dao.AlumnoDao;
import modelo.Alumno;
import utilidades.Util;

public class AlumnoDaoImpl implements AlumnoDao{

	@Override
	public int insertar(Alumno obj) {
		String sql="INSERT INTO alumno(nombre, apellido, identificador, fechaNac) VALUES (?,?,?,?)";
		
		Connection con = null;
		PreparedStatement pstm = null;
		int resultado = 0;
		
		con = Coneccion.conectar();
		
	    try {
			pstm = Coneccion.preparedStatement(con, sql);
			//parametros
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getApellido());
			pstm.setString(3, obj.getIdentificador());
			pstm.setDate(4, Util.sqlDate(obj.getFechaNac()));
			
			
			resultado = pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al ejecutar query de insert : "+ e.getMessage());
		}finally {
			Coneccion.desconectar(con);
			Coneccion.cerrarPreparedStatement(pstm);
		}
		
		return resultado;
	}

	@Override
	public int modificar(Alumno obj) {
		String sql = "UPDATE alumno SET nombre = ?, apellido = ?, fechaNac = ? WHERE alumno.identificador = ? ";
		
		Connection con = null;
		PreparedStatement pstm = null;
		int resultado = 0;
		
		con = Coneccion.conectar();
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getApellido());
			pstm.setDate(3, Util.sqlDate(obj.getFechaNac()));
			pstm.setString(4, obj.getIdentificador());
			
			resultado = pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al modificar alumno: "+ e.getMessage());
		}finally {
			Coneccion.desconectar(con);
			Coneccion.cerrarPreparedStatement(pstm);
		}
		
		return resultado;
	}

	@Override
	public int eliminar(Alumno obj) {
		String sql = "DELETE FROM test.alumno WHERE id_alumno= ?";
		
		Connection con = null;
		PreparedStatement pstm = null;
		int resultado = 0;
		
		con = Coneccion.conectar();
		pstm = Coneccion.preparedStatement(con, sql);
		
		try {
			pstm.setLong(1, obj.getId_alumno());
			
			resultado = pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al eliminar Alumno "+e.getMessage());
		}finally {
			Coneccion.desconectar(con);
			Coneccion.cerrarPreparedStatement(pstm);
		}
		return resultado;
	}

	@Override
	public List<Alumno> listar() {
		String sql = "SELECT * FROM test.alumno";
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rst = null;
		List<Alumno> lst = new ArrayList<>();
		Alumno a = null;
		
		con = Coneccion.conectar();
		pstm = Coneccion.preparedStatement(con, sql);
		
		try {
			rst = pstm.executeQuery();
			
			while (rst.next()) {
				a = new Alumno();
				a.setId_alumno(rst.getLong("id_alumno"));
				a.setNombre(rst.getString("nombre"));
				a.setApellido(rst.getString("apellido"));
				a.setIdentificador(rst.getString("identificador"));
				a.setFechaNac(rst.getDate("fechaNac"));
				lst.add(a);				
			}
			
		} catch (SQLException e) {
			System.out.println("Error al obtener listado de alumnos " + e.getMessage());
		}finally {
			Coneccion.desconectar(con);
			Coneccion.cerrarPreparedStatement(pstm);
		}	
		return lst;
	}

	

	@Override
	public Alumno obtenerPorIdentificacion(String id) {
		String sql = "SELECT * FROM test.alumno where identificador  = ?";
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rst = null;
		Alumno a = null;
		
		con = Coneccion.conectar();
		pstm = Coneccion.preparedStatement(con, sql);
		
		try {
			rst = pstm.executeQuery();
			while (rst.next()) {
				a = new Alumno();
				a.setId_alumno(rst.getLong("id_alumno"));
				a.setNombre(rst.getString("nombre"));
				a.setApellido("apellido");
				a.setIdentificador("identificador");
				a.setFechaNac(rst.getDate("fechaNac"));
			}
			
		} catch (SQLException e) {
			System.out.println("Error al obtener alumno por identificacion " + e.getMessage());
		}finally {
			Coneccion.desconectar(con);
			Coneccion.cerrarPreparedStatement(pstm);
		}
				
		return a;
	}

	@Override
	public Alumno obtenerPorId(Long id) {
    String sql = "SELECT * FROM test.alumno where id_alumno  = ?";
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rst = null;
		Alumno a = null;
		
		con = Coneccion.conectar();
		pstm = Coneccion.preparedStatement(con, sql);
		
		try {
			rst = pstm.executeQuery();
			while (rst.next()) {
				a = new Alumno();
				a.setId_alumno(rst.getLong("id_alumno"));
				a.setNombre(rst.getString("nombre"));
				a.setApellido("apellido");
				a.setIdentificador("identificador");
				a.setFechaNac(rst.getDate("fechaNac"));
			}
			
		} catch (SQLException e) {
			System.out.println("Errro al obtener alumno por id :" + e.getMessage());
		}finally {
			Coneccion.desconectar(con);
			Coneccion.cerrarPreparedStatement(pstm);
		}
				
		return a;
	}

}
