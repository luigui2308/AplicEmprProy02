package model;

import java.util.Collection;

/**
* Define los metodos para un repositorio de datos de promotores
* @see Promoter
* @author Luis Roldan Chacon
* @author Gilberth Arce Hernandez
*/
public interface PromoterRepository
{
	/**
	* Método que permite guardar un Promotor en la Base de Datos.
	* Si el Promotor existe se Actualiza, en caso contrario se Inserta.
	* @param object el Promotor a Guardar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void save(Promoter object);
	
	/**
	* Método que permite eliminar un Promotor en la Base de Datos.
	* @param object el Promotor a Eliminar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void delete(Promoter object);

	/**
	* Método que permite obtener la lista de todos los Promotores de la Base de Datos.
	* Se hace un Select de la tabla Promoter.
	* @return La lista de Promotores del sistema.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection find();
	
	/**
	* Método que permite obtener un Promotor según su ID.
	* @param code Id del Promotor a buscar.
	* @return El Promotor encontrado.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Promoter findByCode(int code);
	
	/**
	* Método que permite obtener un Promotor según su Username, utilizado en el Login.
	* @param username Nombre de usuario del Promotor a buscar.
	* @return El Promotor encontrado.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Promoter findByUsername(String username);
}