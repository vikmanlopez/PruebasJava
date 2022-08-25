package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Alumno {
	private long id_alumno;
	private String identificador;
	private String nombre;
	private String apellido;
	private Date fechaNac;
	public long getId_alumno() {
		return id_alumno;
	}
	public void setId_alumno(long id_alumno) {
		this.id_alumno = id_alumno;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	/*Para sacar fecha*/
	public String getFechaStr() {
		String formato = "dd/MM/yyyy - HH:mm:ss";
		 SimpleDateFormat f = new SimpleDateFormat(formato);
		 return f.format(this.fechaNac);
		 
	}
	
	@Override
	public String toString() {
		return "Alumno [id_alumno=" + id_alumno + ", identificador=" + identificador + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", fechaNac=" + fechaNac + "]";
	}
	
	
}
