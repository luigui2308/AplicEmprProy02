package data;

import model.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
* Clase DAO para la entidad RoleByUser (Rol de Usuario) utilizada para el guardado, borrado y obtención de Roles de Usuario del sistema.
* @see RoleByUser
* @author Luis Roldan Chacon
* @author Gilberth Arce Hernandez
*/
public class RoleByUserDAO extends HibernateDaoSupport implements RoleByUserRepository
{
	/**
	* Método que permite guardar un Rol de Usuario en la Base de Datos.
	* Si el Rol de Usuario existe se Actualiza, en caso contrario se Inserta.
	* @param object el Rol de Usuario a Guardar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void save(RoleByUser object)
	{
		getHibernateTemplate().saveOrUpdate(object);
	}

	/**
	* Método que permite eliminar un Rol de Usuario en la Base de Datos.
	* @param object el Rol de Usuario a Eliminar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void delete(RoleByUser object)
	{
		getHibernateTemplate().delete(object);
	}

	/**
	* Método que permite obtener la lista de todos los Roles de Usuario de la Base de Datos.
	* Se hace un Select de la tabla RoleByUser.
	* @return La lista de Roles de Usuario del sistema.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection find()
	{
		return getHibernateTemplate().find("from RoleByUser");
	}

	/**
	* Método que permite obtener los Roles de un Usuario según el username.
	* @param username Nombre de Usuario a buscar.
	* @return Lista de Roles encontrados.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection findByUsername(String username)
	{
		return getHibernateTemplate().find("from RoleByUser where username = ?", username);
	}
}