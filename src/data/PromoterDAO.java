package data;

import model.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
* Clase DAO para la entidad Promoter (Promotor) utilizada para el guardado, borrado y obtenci�n de Promotores del sistema.
* @see Promoter
* @author Luis Roldan Chacon
* @author Gilberth Arce Hernandez
*/
public class PromoterDAO extends HibernateDaoSupport implements PromoterRepository
{
	/**
	* M�todo que permite guardar un Promotor en la Base de Datos.
	* Si el Promotor existe se Actualiza, en caso contrario se Inserta.
	* @param object el Promotor a Guardar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void save(Promoter object)
	{
		getHibernateTemplate().saveOrUpdate(object);
	}
	
	/**
	* M�todo que permite eliminar un Promotor en la Base de Datos.
	* @param object el Promotor a Eliminar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void delete(Promoter object)
	{
		getHibernateTemplate().delete(object);
	}

	/**
	* M�todo que permite obtener la lista de todos los Promotores de la Base de Datos.
	* Se hace un Select de la tabla Promoter.
	* @return La lista de Promotores del sistema.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection find()
	{
		return getHibernateTemplate().find("from Promoter");
	}
	
	/**
	* M�todo que permite obtener un Promotor seg�n su ID.
	* @param code Id del Promotor a buscar.
	* @return El Promotor encontrado.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Promoter findByCode(int code)
	{
		return getHibernateTemplate().get(Promoter.class, code);
	}
	
	/**
	* M�todo que permite obtener un Promotor seg�n su Username, utilizado en el Login.
	* @param username Nombre de usuario del Promotor a buscar.
	* @return El Promotor encontrado.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Promoter findByUsername(String username)
	{
		return (Promoter)getHibernateTemplate().find("from Promoter where username=?", username).get(0);
	}
}