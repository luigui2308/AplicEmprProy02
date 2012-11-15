package data;

import model.*;

/**
 * Se encarga de crear instancias para la clase de tiquetes
 * @see Ticket
 * @author Luis Roldan Chacon
 * @author Gilberth Arce Hernandez
 */
public class TicketFactory
{
	/**
	 * Recibe los parametros necesarios para crear una instancia de Ticket y la retorna
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public Ticket create(int code, int locationTypeId, int eventId, String customerId, String date, int quantity, int amount)
	{
		return new Ticket(code, locationTypeId, eventId, customerId, date, quantity, amount);
	}
}