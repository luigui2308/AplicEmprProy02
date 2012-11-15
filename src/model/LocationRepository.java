package model;

import java.util.Collection;

/**
* Define los metodos para un repositorio de datos de localidades
* @see Location
* @author Luis Roldan Chacon
* @author Gilberth Arce Hernandez
*/
public interface LocationRepository
{
	/**
	* Método que permite guardar un Localidad en la Base de Datos.
	* Si el Localidad existe se Actualiza, en caso contrario se Inserta.
	* @param object el Localidad a Guardar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void save(Location object);
	
	/**
	* Método que permite eliminar una Localidad en la Base de Datos.
	* @param object el Localidad a Eliminar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void delete(Location object);
	
	/**
	* Método que permite eliminar las localidades de un Evento.
	* @param eventCode El codigo del Evento a buscar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void deleteByEvent(int eventCode);
	
	/**
	* Método que permite obtener la lista de localidades de un Evento.
	* @param eventCode Id del Evento a buscar.
	* @return La lista de localidades del Evento.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection findByEvent(int eventCode);
	
	/**
	* Método que permite obtener una localidad según su tipo y evento.
	* @param locationTypeId tipo de Localidad a buscar.
	* @param eventCode Id del Evento a buscar.
	* @return La Localidad encontrada.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Location findById(int locationTypeId, int eventCode);

	/**
	* Método que permite obtener la lista de todos los Localidades de la Base de Datos.
	* Se hace un Select de la tabla Location.
	* @return La lista de Localidades del sistema.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection find();
}