package data;

import model.*;

/**
 * Se encarga de crear instancias para la clase de promotores
 * @see Promoter
 * @author Luis Roldan Chacon
 * @author Gilberth Arce Hernandez
 */
public class PromoterFactory
{
	/**
	 * Recibe los parametros necesarios para crear una instancia de Promoter y la retorna
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public Promoter create(int code, String name, String address, String telephone, String account, String bank, int comission, String username)
	{
		return new Promoter(code, name, address, telephone, account, bank, comission, username);
	}
}