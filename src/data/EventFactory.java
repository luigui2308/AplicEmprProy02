package data;

import model.*;

/**
 * Se encarga de crear instancias para la clase de Eventos
 * @see Event
 * @author Luis Roldan Chacon
 * @author Gilberth Arce Hernandez
 */
public class EventFactory
{
	/**
	 * Recibe los parametros necesarios para crear una instancia de Event y la retorna
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public Event create(int code, String name, int eventTypeCode, String artists, String date, String place, int promoterId)
	{
		return new Event(code, name, eventTypeCode, artists, date, place, promoterId);
	}
}