package model;

import java.util.Collection;

/**
* Define los metodos para un repositorio de datos de tiquetes numerados
* @see NumberedTicket
* @author Luis Roldan Chacon
* @author Gilberth Arce Hernandez
*/
public interface NumberedLocationRepository
{
	/**
	* Método que permite guardar una Localidad Numerada en la Base de Datos.
	* Si la Localidad Numerada existe se Actualiza, en caso contrario se Inserta.
	* @param object el Localidad Numerada a Guardar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void save(NumberedLocation object);
	
	/**
	* Método que permite eliminar una Localidad Numerada de la Base de Datos.
	* @param object la Localidad Numerada a Eliminar.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public void delete(NumberedLocation object);

	/**
	* Método que permite obtener la lista de todas las Localidades Numeradas de la Base de Datos.
	* Se hace un Select de la tabla NumberedLocation.
	* @return La lista de Localidades Numeradas del sistema.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection find();
	
	/**
	* Método que permite obtener un tiquete numerado segun su ID
	* @param locationNumber Numero de asiento
	* @param ticketId Numero de Tiquete a buscar.
	* @return Tiquete numerado
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public NumberedLocation findById(int locationNumber, int ticketId);
	
	/**
	* Método que permite obtener una lista de localidades de un Tiquete.
	* @param ticketCode Numero de Tiquete a buscar.
	* @return Lista de Localidades Numeradas encontradas.
	* @author Luis Roldan Chacon
	* @author Gilberth Arce Hernandez
	*/
	public Collection findByTicketCode(int ticketCode);
}