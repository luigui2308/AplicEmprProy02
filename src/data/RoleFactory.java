package data;

import model.*;

/**
 * Se encarga de crear instancias para la clase de roles
 * @see Role
 * @author Luis Roldan Chacon
 * @author Gilberth Arce Hernandez
 */
public class RoleFactory
{
	/**
	 * Recibe los parametros necesarios para crear una instancia de Role y la retorna
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public Role create(int code, String description)
	{
		return new Role(code, description);
	}
}