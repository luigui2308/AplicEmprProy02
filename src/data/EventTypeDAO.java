package data;

import model.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
* Clase DAO para la entidad EventType (Tipo de Evento) utilizada para el guardado, borrado y obtención de Tipos de Evento del sistema.
* @see EventType
* @author Luis Roldan Chacon
* @author Gilberth Arce Hernandez
*/
public class EventTypeDAO extends HibernateDaoSupport implements EventTypeRepository
{
	/**
	* Método que permite guardar un Tipo de Evento en la Base de Datos.
	* Si el Tipo de Evento existe se Actualiza, en caso contrario se Inserta.
	* @param object el Tipo de Evento a Guardar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void save(EventType object)
	{
		getHibernateTemplate().saveOrUpdate(object);
	}
	
	/**
	* Método que permite eliminar un Tipo de Evento en la Base de Datos.
	* @param object el Tipo de Evento a Eliminar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void delete(EventType object)
	{
		getHibernateTemplate().delete(object);
	}

	/**
	* Método que permite obtener la lista de todos los Tipos de Evento de la Base de Datos.
	* Se hace un Select de la tabla EventType.
	* @return La lista de Tipos de Evento del sistema.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection find()
	{
		return getHibernateTemplate().find("from EventType");
	}
}