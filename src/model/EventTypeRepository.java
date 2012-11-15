package model;

import java.util.Collection;

/**
* Define los metodos para un repositorio de datos de tipos de eventos
* @see EventType
* @author Luis Roldan Chacon
* @author Gilberth Arce Hernandez
*/
public interface EventTypeRepository
{
	/**
	* Método que permite guardar un Tipo de Evento en la Base de Datos.
	* Si el Tipo de Evento existe se Actualiza, en caso contrario se Inserta.
	* @param object el Tipo de Evento a Guardar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void save(EventType object);
	
	/**
	* Método que permite eliminar un Tipo de Evento en la Base de Datos.
	* @param object el Tipo de Evento a Eliminar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void delete(EventType object);

	/**
	* Método que permite obtener la lista de todos los Tipos de Evento de la Base de Datos.
	* Se hace un Select de la tabla EventType.
	* @return La lista de Tipos de Evento del sistema.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection find();
}