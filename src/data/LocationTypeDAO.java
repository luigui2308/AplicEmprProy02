package data;

import model.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
* Clase DAO para la entidad LocationType (Tipo de Localidad) utilizada para el guardado, borrado y obtención de Tipos de Localidad del sistema.
* @see LocationType
* @author Luis Roldan Chacon
* @author Gilberth Arce Hernandez
*/
public class LocationTypeDAO extends HibernateDaoSupport implements LocationTypeRepository
{
	/**
	* Método que permite guardar un Tipo de Localidad en la Base de Datos.
	* Si el Tipo de Localidad existe se Actualiza, en caso contrario se Inserta.
	* @param object el Tipo de Localidad a Guardar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void save(LocationType object)
	{
		getHibernateTemplate().saveOrUpdate(object);
	}
	
	/**
	* Método que permite eliminar un Tipo de Localidad en la Base de Datos.
	* @param object el Tipo de Localidad a Eliminar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void delete(LocationType object)
	{
		getHibernateTemplate().delete(object);
	}

	/**
	* Método que permite obtener la lista de todos los Tipos de Localidad de la Base de Datos.
	* Se hace un Select de la tabla LocationType.
	* @return La lista de Tipos de Localidad del sistema.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection find()
	{
		return getHibernateTemplate().find("from LocationType");
	}
}