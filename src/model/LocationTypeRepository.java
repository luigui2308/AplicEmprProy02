package model;

import java.util.Collection;

/**
* Define los metodos para un repositorio de datos de tipos de localidades
* @see LocationType
* @author Luis Roldan Chacon
* @author Gilberth Arce Hernandez
*/
public interface LocationTypeRepository
{
	/**
	* Método que permite guardar un Tipo de Localidad en la Base de Datos.
	* Si el Tipo de Localidad existe se Actualiza, en caso contrario se Inserta.
	* @param object el Tipo de Localidad a Guardar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void save(LocationType object);
	
	/**
	* Método que permite eliminar un Tipo de Localidad en la Base de Datos.
	* @param object el Tipo de Localidad a Eliminar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void delete(LocationType object);

	/**
	* Método que permite obtener la lista de todos los Tipos de Localidad de la Base de Datos.
	* Se hace un Select de la tabla LocationType.
	* @return La lista de Tipos de Localidad del sistema.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection find();
}