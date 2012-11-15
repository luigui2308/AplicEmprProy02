package data;

import model.*;

/**
 * Se encarga de crear instancias para la clase de usuarios
 * @see User
 * @author Luis Roldan Chacon
 * @author Gilberth Arce Hernandez
 */
public class UserFactory
{
	/**
	 * Recibe los parametros necesarios para crear una instancia de User y la retorna
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public User create(String username, String password)
	{
		return new User(username, password);
	}
}