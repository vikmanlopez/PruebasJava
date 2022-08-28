package dao;

import java.util.List;
// generico
public interface Dao <T,K>{ // T es cualquier objeto y K es la llave primaria
	public int insertar(T obj);
	public int modificar(T obj);
	public int eliminar(T obj);
	public List<T> listar();
	public T obtenerPorId(K id);
	public T obtenerPorIdentificacion(String identificacion);
	

}

/* Asi seria lo especifico, pero si se neceitan muchos objetos de acceso a datos seria uno por entidad
 public interface Dao { // T es cualquier objeto y K es la llave primaria
	public int insertar(Alumno obj);
	public int modificar(Alumno obj);
	public int eliminar(Alumno obj);
	public List<Alumno> listar();
	public Alumno obtenerPorId(int id);
	public Alumno obtenerPorIdentificacion(String id);
	
}
 * */
