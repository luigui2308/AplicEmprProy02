package data;

import model.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
* Clase DAO para la entidad Ticket (Tiquete) utilizada para el guardado, borrado y obtención de Tiquetes del sistema.
* @see Ticket
* @author Luis Roldan Chacon
* @author Gilberth Arce Hernandez
*/
public class TicketDAO extends HibernateDaoSupport implements TicketRepository
{
	/**
	* Método que permite guardar un Tiquete en la Base de Datos.
	* Si el Tiquete existe se Actualiza, en caso contrario se Inserta.
	* @param object el Tiquete a Guardar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void save(Ticket object)
	{
		getHibernateTemplate().saveOrUpdate(object);
	}
	
	/**
	* Método que permite eliminar un Tiquete en la Base de Datos.
	* @param object el Tiquete a Eliminar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void delete(Ticket object)
	{
		getHibernateTemplate().delete(object);
	}

	/**
	* Método que permite obtener la lista de todos los Tiquetes de la Base de Datos.
	* Se hace un Select de la tabla Ticket.
	* @return La lista de Tiquetes del sistema.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection find()
	{
		return getHibernateTemplate().find("from Ticket");
	}
	
	/**
	* Método que permite obtener la lista de los Tiquetes de un Evento.
	* Se hace un Select de la tabla Ticket.
	* @return La lista de Tiquetes del evento a buscar.
	* @param eventCode Codigo del Evento a buscar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection findByEvent(int eventCode)
	{
		return getHibernateTemplate().find("from Ticket where eventId=?", eventCode);
	}
	
	/**
	* Método que permite obtener la lista de los tiquetes de un evento de un tipo determinado.
	* Se hace un Select de la tabla Ticket.
	* @param locationTypeId tipo de localidad a buscar.
	* @param eventCode Codigo del Evento a buscar.
	* @return La lista de Tiquetes del sistema.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection findByEventAndLocation(int eventCode, int locationTypeId)
	{
		return getHibernateTemplate().find("from Ticket where locationTypeId=? and eventId=?", locationTypeId, eventCode);
	}
	
	/**
	* Método que permite obtener un Tiquete según su ID.
	* Recibe por parámetro el ID del Tiquete.
	* @param code Id del Tiquete a buscar.
	* @return El Tiquete encontrado.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Ticket findByCode(int code)
	{
		return getHibernateTemplate().get(Ticket.class, new Integer(code));
	}
}