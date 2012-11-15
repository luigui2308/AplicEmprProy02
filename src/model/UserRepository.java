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
	* M�todo que permite guardar un Usuario en la Base de Datos.
	* Si el Usuario existe se Actualiza, en caso contrario se Inserta.
	* @param object el Usuario a Guardar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void save(User object);
	
	/**
	* M�todo que permite eliminar un Usuario en la Base de Datos.
	* @param object el Usuario a Eliminar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void delete(User object);

	/**
	* M�todo que permite obtener la lista de todos los Usuarios de la Base de Datos.
	* Se hace un Select de la tabla User.
	* @return La lista de Usuarios del sistema.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection find();
	
	/**
	* M�todo que permite obtener un Usuario seg�n el nombre de usuario.
	* @param username Id del Usuario a buscar.
	* @return El Usuario encontrado.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public User findByUsername(String username);
}