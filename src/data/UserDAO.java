package data;

import model.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
* Clase DAO para la entidad User (Usuario) utilizada para el guardado, borrado y obtención de Usuarios del sistema.
* @see User
* @author Luis Roldan Chacon
* @author Gilberth Arce Hernandez
*/
public class UserDAO extends HibernateDaoSupport implements UserRepository
{
	/**
	* Método que permite guardar un Usuario en la Base de Datos.
	* Si el Usuario existe se Actualiza, en caso contrario se Inserta.
	* @param object el Usuario a Guardar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void save(User object)
	{
		getHibernateTemplate().saveOrUpdate(object);
	}
	
	/**
	* Método que permite eliminar un Usuario en la Base de Datos.
	* @param object el Usuario a Eliminar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void delete(User object)
	{
		getHibernateTemplate().delete(object);
	}

	/**
	* Método que permite obtener la lista de todos los Usuarios de la Base de Datos.
	* Se hace un Select de la tabla User.
	* @return La lista de Usuarios del sistema.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection find()
	{
		return getHibernateTemplate().find("from User");
	}
	
	/**
	* Método que permite obtener un Usuario según el nombre de usuario.
	* @param username Id del Usuario a buscar.
	* @return El Usuario encontrado.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public User findByUsername(String username)
	{
		return (User)getHibernateTemplate().get(User.class, username);
	}
}