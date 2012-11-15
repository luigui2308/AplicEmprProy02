package data;

import model.*;

/**
 * Se encarga de crear instancias para la clase de Localidades
 * @see Location
 * @author Luis Roldan Chacon
 * @author Gilberth Arce Hernandez
 */
public class LocationFactory
{
	/**
	 * Recibe los parametros necesarios para crear una instancia de Location y la retorna
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public Location create(int locationTypeId, int event, int price, int quantity, boolean numbered)
	{
		return new Location(locationTypeId, event, price, quantity, numbered);
	}
}