package data;

import model.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
* Clase DAO para la entidad Event(Evento) utilizada para el guardado, borrado y obtenci�n de Eventos del sistema.
* Posee una funci�n para obtener un Evento de acuerdo a su ID y otra para obtener los eventos de un determinado Promotor.
* @see Event
* @author Luis Roldan Chacon
* @author Gilberth Arce Hernandez
*/
public class EventDAO extends HibernateDaoSupport implements EventRepository
{
	/**
	* M�todo que permite guardar un Evento en la Base de Datos.
	* Si el Evento existe se Actualiza, en caso contrario se Inserta.
	* @param object el Evento a Guardar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void save(Event object)
	{
		getHibernateTemplate().saveOrUpdate(object);
	}
	
	/**
	* M�todo que permite eliminar un Evento en la Base de Datos.
	* @param object el Evento a Eliminar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void delete(Event object)
	{
		getHibernateTemplate().delete(object);
	}

	/**
	* M�todo que permite obtener la lista de todos los eventos de la Base de Datos.
	* Se hace un Select de la tabla Event.
	* @return La lista de Eventos del sistema.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection find()
	{
		return getHibernateTemplate().find("from Event");
	}
	
	/**
	* M�todo que permite obtener un Evento seg�n su ID.
	* Recibe por par�metro el ID del Evento.
	* @param code Id del Evento a buscar.
	* @return El Evento encontrado.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Event findByCode(int code)
	{
		return getHibernateTemplate().get(Event.class, code);
	}
	
	/**
	* M�todo que permite obtener la lista de todos los eventos de un determinado Promotor.
	* @return La lista de Eventos del promotor.
	* @param code Codigo del Promotor a buscar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection findByPromoter(int code)
	{
		return getHibernateTemplate().find("from Event where promoterId=?", code);
	}
}