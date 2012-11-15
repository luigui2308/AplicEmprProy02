package data;

import model.*;

/**
 * Se encarga de crear instancias para la clase de ticket's numerados
 * @see NumberedLocation
 * @author Luis Roldan Chacon
 * @author Gilberth Arce Hernandez
 */
public class NumberedLocationFactory
{
	/**
	 * Recibe los parametros necesarios para crear una instancia de NumberedLocation y la retorna
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public NumberedLocation create(int locationNumber, int ticketId)
	{
		return new NumberedLocation(locationNumber, ticketId);
	}
}