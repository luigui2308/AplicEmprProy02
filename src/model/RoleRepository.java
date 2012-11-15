package model;

import model.*;
import java.util.Collection;

/**
* Define los metodos para un repositorio de datos de Roles
* @see Role
* @author Luis Roldan Chacon
* @author Gilberth Arce Hernandez
*/
public interface RoleRepository
{
	/**
	* Método que permite guardar un Rol en la Base de Datos.
	* Si el Rol existe se Actualiza, en caso contrario se Inserta.
	* @param object el Rol a Guardar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void save(Role object);
	
	/**
	* Método que permite eliminar un Rol en la Base de Datos.
	* @param object el Rol a Eliminar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void delete(Role object);

	/**
	* Método que permite obtener la lista de todos los Roles de la Base de Datos.
	* Se hace un Select de la tabla Role.
	* @return La lista de Roles del sistema.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection find();
}