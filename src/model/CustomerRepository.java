package model;

import java.util.Collection;

/**
* Define los metodos para un repositorio de datos de clientes
* @see Customer
* @author Luis Roldan Chacon
* @author Gilberth Arce Hernandez
*/
public interface CustomerRepository
{
	/**
	* M�todo que permite guardar un Cliente en la Base de Datos.
	* Si el Cliente existe se Actualiza, en caso contrario se Inserta.
	* @param object el cliente a Guardar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void save(Customer object);
	
	/**
	* M�todo que permite eliminar un Cliente en la Base de Datos.
	* @param object el cliente a Eliminar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void delete(Customer object);

	/**
	* M�todo que permite obtener la lista de todos los clientes de la Base de Datos.
	* Se hace un Select de la tabla Customer.
	* @return La lista de Clientes del sistema.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection find();
	
	/**
	* M�todo que permite obtener un Cliente seg�n su ID.
	* Recibe por par�metro el ID del cliente.
	* @param id Id del Cliente a buscar.
	* @return El cliente encontrado.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Customer findById(String id);
}