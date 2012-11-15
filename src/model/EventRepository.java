package model;

import java.util.Collection;

/**
* Define los metodos para un repositorio de datos de eventos
* @see Event
* @author Luis Roldan Chacon
* @author Gilberth Arce Hernandez
*/
public interface EventRepository
{
	/**
	* M�todo que permite guardar un Evento en la Base de Datos.
	* Si el Evento existe se Actualiza, en caso contrario se Inserta.
	* @param object el Evento a Guardar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void save(Event object);
	
	/**
	* M�todo que permite eliminar un Evento en la Base de Datos.
	* @param object el Evento a Eliminar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void delete(Event object);

	/**
	* M�todo que permite obtener la lista de todos los eventos de la Base de Datos.
	* Se hace un Select de la tabla Event.
	* @return La lista de Eventos del sistema.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection find();
	
	/**
	* M�todo que permite obtener un Evento seg�n su ID.
	* Recibe por par�metro el ID del Evento.
	* @param code Id del Evento a buscar.
	* @return El Evento encontrado.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Event findByCode(int code);
	
	/**
	* M�todo que permite obtener la lista de todos los eventos de un determinado Promotor.
	* @return La lista de Eventos del promotor.
	* @param code Codigo del Promotor a buscar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection findByPromoter(int code);
}