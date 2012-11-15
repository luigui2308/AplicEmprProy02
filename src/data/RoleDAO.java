package data;

import model.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
* Clase DAO para la entidad Role (Rol) utilizada para el guardado, borrado y obtención de Roles del sistema.
* @see Role
* @author Luis Roldan Chacon
* @author Gilberth Arce Hernandez
*/
public class RoleDAO extends HibernateDaoSupport implements RoleRepository
{
	/**
	* Método que permite guardar un Rol en la Base de Datos.
	* Si el Rol existe se Actualiza, en caso contrario se Inserta.
	* @param object el Rol a Guardar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void save(Role object)
	{
		getHibernateTemplate().saveOrUpdate(object);
	}
	
	/**
	* Método que permite eliminar un Rol en la Base de Datos.
	* @param object el Rol a Eliminar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void delete(Role object)
	{
		getHibernateTemplate().delete(object);
	}

	/**
	* Método que permite obtener la lista de todos los Roles de la Base de Datos.
	* Se hace un Select de la tabla Role.
	* @return La lista de Roles del sistema.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection find()
	{
		return getHibernateTemplate().find("from Role");
	}
}