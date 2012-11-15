package data;

import model.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
* Clase DAO para la entidad Customer (Cliente) utilizada para el guardado, borrado y obtenci�n de Clientes del sistema.
* Posee una funci�n para obtener un Cliente de acuerdo a su ID.
* @see Customer
* @author Luis Roldan Chacon
* @author Gilberth Arce Hernandez
*/
public class CustomerDAO extends HibernateDaoSupport implements CustomerRepository
{
	/**
	* M�todo que permite guardar un Cliente en la Base de Datos.
	* Si el Cliente existe se Actualiza, en caso contrario se Inserta.
	* @param object el cliente a Guardar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void save(Customer object)
	{
		getHibernateTemplate().saveOrUpdate(object);
	}
	
	/**
	* M�todo que permite eliminar un Cliente en la Base de Datos.
	* @param object el cliente a Eliminar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void delete(Customer object)
	{
		getHibernateTemplate().delete(object);
	}

	/**
	* M�todo que permite obtener la lista de todos los clientes de la Base de Datos.
	* Se hace un Select de la tabla Customer.
	* @return La lista de Clientes del sistema.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection find()
	{
		return getHibernateTemplate().find("from Customer");
	}
	
	/**
	* M�todo que permite obtener un Cliente seg�n su ID.
	* Recibe por par�metro el ID del cliente.
	* @param id Id del Cliente a buscar.
	* @return El cliente encontrado.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Customer findById(String id)
	{
		return (Customer)getHibernateTemplate().get(Customer.class, id);
	}
}