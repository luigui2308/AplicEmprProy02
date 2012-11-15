package data;

import model.*;

/**
 * Se encarga de crear instancias para la clase de roles por usuarios
 * @see RoleByUser
 * @author Luis Roldan Chacon
 * @author Gilberth Arce Hernandez
 */
public class RoleByUserFactory
{
	/**
	 * Recibe los parametros necesarios para crear una instancia de RoleByUser y la retorna
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public RoleByUser create(String username, int roleCode)
	{
		return new RoleByUser(username, roleCode);
	}
}