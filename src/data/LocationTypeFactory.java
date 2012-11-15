package data;

import model.*;

/**
 * Se encarga de crear instancias para la clase de tipos de localidades
 * @see LocationType
 * @author Luis Roldan Chacon
 * @author Gilberth Arce Hernandez
 */
public class LocationTypeFactory
{
	/**
	 * Recibe los parametros necesarios para crear una instancia de LocationType y la retorna
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public LocationType create(int code, String description)
	{
		return new LocationType(code, description);
	}
}