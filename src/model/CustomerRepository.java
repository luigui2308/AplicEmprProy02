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
	* Método que permite guardar un Cliente en la Base de Datos.
	* Si el Cliente existe se Actualiza, en caso contrario se Inserta.
	* @param object el cliente a Guardar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void save(Customer object);
	
	/**
	* Método que permite eliminar un Cliente en la Base de Datos.
	* @param object el cliente a Eliminar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void delete(Customer object);

	/**
	* Método que permite obtener la lista de todos los clientes de la Base de Datos.
	* Se hace un Select de la tabla Customer.
	* @return La lista de Clientes del sistema.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection find();
	
	/**
	* Método que permite obtener un Cliente según su ID.
	* Recibe por parámetro el ID del cliente.
	* @param id Id del Cliente a buscar.
	* @return El cliente encontrado.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Customer findById(String id);
}