package model;

import java.util.Collection;

/**
* Define los metodos para un repositorio de datos de tiquetes
* @see Ticket
* @author Luis Roldan Chacon
* @author Gilberth Arce Hernandez
*/
public interface TicketRepository
{
	/**
	* Método que permite guardar un Tiquete en la Base de Datos.
	* Si el Tiquete existe se Actualiza, en caso contrario se Inserta.
	* @param object el Tiquete a Guardar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void save(Ticket object);
	
	/**
	* Método que permite eliminar un Tiquete en la Base de Datos.
	* @param object el Tiquete a Eliminar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void delete(Ticket object);

	/**
	* Método que permite obtener la lista de todos los Tiquetes de la Base de Datos.
	* Se hace un Select de la tabla Ticket.
	* @return La lista de Tiquetes del sistema.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection find();
	
	/**
	* Método que permite obtener la lista de los Tiquetes de un Evento.
	* Se hace un Select de la tabla Ticket.
	* @return La lista de Tiquetes del evento a buscar.
	* @param eventCode Codigo del Evento a buscar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection findByEvent(int eventCode);
	
	/**
	* Método que permite obtener la lista de los tiquetes de un evento de un tipo determinado.
	* Se hace un Select de la tabla Ticket.
	* @param locationTypeId tipo de localidad a buscar.
	* @param eventCode Codigo del Evento a buscar.
	* @return La lista de Tiquetes del sistema.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection findByEventAndLocation(int eventCode, int locationTypeId);
	
	/**
	* Método que permite obtener un Tiquete según su ID.
	* Recibe por parámetro el ID del Tiquete.
	* @param code Id del Tiquete a buscar.
	* @return El Tiquete encontrado.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Ticket findByCode(int code);
}