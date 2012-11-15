package model;

import java.util.Collection;

/**
* Define los metodos para un repositorio de datos de Roles por usuario
* @see RoleByUser
* @author Luis Roldan Chacon
* @author Gilberth Arce Hernandez
*/
public interface RoleByUserRepository
{
	/**
	* Método que permite guardar un Rol de Usuario en la Base de Datos.
	* Si el Rol de Usuario existe se Actualiza, en caso contrario se Inserta.
	* @param object el Rol de Usuario a Guardar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void save(RoleByUser object);

	/**
	* Método que permite eliminar un Rol de Usuario en la Base de Datos.
	* @param object el Rol de Usuario a Eliminar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void delete(RoleByUser object);

	/**
	* Método que permite obtener la lista de todos los Roles de Usuario de la Base de Datos.
	* Se hace un Select de la tabla RoleByUser.
	* @return La lista de Roles de Usuario del sistema.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection find();

	/**
	* Método que permite obtener los Roles de un Usuario según el username.
	* @param username Nombre de Usuario a buscar.
	* @return Lista de Roles encontrados.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection findByUsername(String username);
}