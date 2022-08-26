package utilidades;

import java.util.Date;

public class Util {
	/*
	 * Metodo que recibe una fecha de tipo ava.util.Date y retorna un ava.sql.Date
	 */
	public static java.sql.Date sqlDate(Date fecha){
		
		return new java.sql.Date(fecha.getTime());
	}

}
