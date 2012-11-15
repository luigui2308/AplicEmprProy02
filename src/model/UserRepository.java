package model;

import java.util.Collection;

/**
* Define los metodos para un repositorio de datos de usuarios
* @see User
* @author Luis Roldan Chacon
* @author Gilberth Arce Hernandez
*/
public interface UserRepository
{
	/**
	* Método que permite guardar un Usuario en la Base de Datos.
	* Si el Usuario existe se Actualiza, en caso contrario se Inserta.
	* @param object el Usuario a Guardar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void save(User object);
	
	/**
	* Método que permite eliminar un Usuario en la Base de Datos.
	* @param object el Usuario a Eliminar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void delete(User object);

	/**
	* Método que permite obtener la lista de todos los Usuarios de la Base de Datos.
	* Se hace un Select de la tabla User.
	* @return La lista de Usuarios del sistema.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection find();
	
	/**
	* Método que permite obtener un Usuario según el nombre de usuario.
	* @param username Id del Usuario a buscar.
	* @return El Usuario encontrado.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public User findByUsername(String username);
}