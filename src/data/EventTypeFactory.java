package data;

import model.*;

/**
 * Se encarga de crear instancias para la clase de tipos de evento
 * @see EventType
 * @author Luis Roldan Chacon
 * @author Gilberth Arce Hernandez
 */
public class EventTypeFactory
{
	/**
	 * Recibe los parametros necesarios para crear una instancia de EventType y la retorna
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public EventType create(int code, String description)
	{
		return new EventType(code, description);
	}
}