package data;

import model.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
* Clase DAO para la entidad NumberedLocation (Localidad Numerada) utilizada para el guardado, borrado y obtención de Localidades Numeradas del sistema.
* Posee una función para obtener un Localidad Numerada de acuerdo a su ID.
* @see NumberedLocation
* @author Luis Roldan Chacon
* @author Gilberth Arce Hernandez
*/
public class NumberedLocationDAO extends HibernateDaoSupport implements NumberedLocationRepository
{
	/**
	* Método que permite guardar una Localidad Numerada en la Base de Datos.
	* Si la Localidad Numerada existe se Actualiza, en caso contrario se Inserta.
	* @param object el Localidad Numerada a Guardar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void save(NumberedLocation object)
	{
		getHibernateTemplate().saveOrUpdate(object);
	}
	
	/**
	* Método que permite eliminar una Localidad Numerada de la Base de Datos.
	* @param object la Localidad Numerada a Eliminar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void delete(NumberedLocation object)
	{
		getHibernateTemplate().delete(object);
	}

	/**
	* Método que permite obtener la lista de todas las Localidades Numeradas de la Base de Datos.
	* Se hace un Select de la tabla NumberedLocation.
	* @return La lista de Localidades Numeradas del sistema.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection find()
	{
		return getHibernateTemplate().find("from NumberedLocation");
	}
	
	/**
	* Método que permite obtener un tiquete numerado segun su ID
	* @param locationNumber Numero de asiento
	* @param ticketId Numero de Tiquete a buscar.
	* @return Tiquete numerado
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public NumberedLocation findById(int locationNumber, int ticketId)
	{
		List numberedTickets = getHibernateTemplate().find("from NumberedLocation where locationNumber=? and ticketId=?", locationNumber, ticketId);
		return numberedTickets.isEmpty() ? null : (NumberedLocation)numberedTickets.get(0);
	}
	
	/**
	* Método que permite obtener una lista de localidades de un Tiquete.
	* @param ticketCode Numero de Tiquete a buscar.
	* @return Lista de Localidades Numeradas encontradas.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection findByTicketCode(int ticketCode)
	{
		return getHibernateTemplate().find("from NumberedLocation where ticketId=?", ticketCode);
	}
}