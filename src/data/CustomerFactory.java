package data;

import model.*;

/**
 * Se encarga de crear instancias para la clase de Cliente
 * @see Customer
 * @author Luis Roldan Chacon
 * @author Gilberth Arce Hernandez
 */
public class CustomerFactory
{
	/**
	 * Recibe los parametros necesarios para crear una instancia de Customer y la retorna
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public Customer create(String id, String name, String address, String telephone, String cardNumber, String cardType)
	{
		return new Customer(id, name, address, telephone, cardNumber, cardType);
	}
}