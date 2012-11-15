package model;

import java.io.Serializable;

/**
 * Representa una localidad para el sistema, esta se asocia a un evento, un evento puede tener tantas localidades
 * como esten definidas en el sistema por medio de los tipos de localidades. Los tickets se asocian a las localidades
 * un promotor puede agregar o quitar localidades de un evento
 * @see LocationType
 * @see Event
 * @see Promoter
 * @author Luis Roldan Chacon
 * @author Gilberth Arce Hernandez
 */
public class Location implements Serializable
{
	private int locationTypeId;
	private int event;
	private int price;
	private int quantity;
	private boolean numbered;
	
	/**
	 * Constructor sin parametros que ayuda a la creacion de objetos vacios
	 * Estos son funcionales cuando no se cuenta con toda la informacion para la creacion del objeto
	 * o se quiere llenar la informacion poco a poco
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public Location()
	{
	}
	
	/**
	 * Constructor con parametros que ayuda a la creacion de objetos llenos
	 * Estos son funcionales cuando se cuenta con toda la informacion para la creacion del objeto
	 * y/o no se quiere guardar una referencia hacia un objeto
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public Location(int locationTypeId, int event, int price, int quantity, boolean numbered)
	{
		this.locationTypeId=locationTypeId;
		this.event=event;
		this.price=price;
		this.quantity=quantity;
		this.numbered=numbered;
	}
	
	/**
	 * Constructor de copia que hace que un objeto tenga los mismos valores de otro
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public Location(Location locationDTO)
	{
		this.locationTypeId=locationDTO.getLocationTypeId();
		this.event=locationDTO.getEvent();
		this.price=locationDTO.getPrice();
		this.quantity=locationDTO.getQuantity();
		this.numbered=locationDTO.getNumbered();
	}
	
	/**
	 * Metodo que que obtiene el valor de una propiedad determinada (get, accesor) segun el valor de la propiedad
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de obtener una propiedad
	 * @return valor del atributo asociado a este accesor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public int getLocationTypeId()
	{
		return this.locationTypeId;
	}
	
	/**
	 * Metodo que que establece el valor de una propiedad determinada (set, mutador) segun un valor pasado por parametro
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de establecer una propiedad
	 * @param x nuevo valor del atributo
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setLocationTypeId(int x)
	{
		this.locationTypeId=x;
	}
	
	/**
	 * Metodo que que obtiene el valor de una propiedad determinada (get, accesor) segun el valor de la propiedad
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de obtener una propiedad
	 * @return valor del atributo asociado a este accesor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public int getEvent()
	{
		return this.event;
	}
	
	/**
	 * Metodo que que establece el valor de una propiedad determinada (set, mutador) segun un valor pasado por parametro
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de establecer una propiedad
	 * @param x nuevo valor del atributo
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setEvent(int x)
	{
		this.event=x;
	}
	
	/**
	 * Metodo que que obtiene el valor de una propiedad determinada (get, accesor) segun el valor de la propiedad
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de obtener una propiedad
	 * @return valor del atributo asociado a este accesor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public int getPrice()
	{
		return this.price;
	}
	
	/**
	 * Metodo que que establece el valor de una propiedad determinada (set, mutador) segun un valor pasado por parametro
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de establecer una propiedad
	 * @param x nuevo valor del atributo
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setPrice(int x)
	{
		this.price=x;
	}
	
	/**
	 * Metodo que que obtiene el valor de una propiedad determinada (get, accesor) segun el valor de la propiedad
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de obtener una propiedad
	 * @return valor del atributo asociado a este accesor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public int getQuantity()
	{
		return this.quantity;
	}
	
	/**
	 * Metodo que que establece el valor de una propiedad determinada (set, mutador) segun un valor pasado por parametro
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de establecer una propiedad
	 * @param x nuevo valor del atributo
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setQuantity(int x)
	{
		this.quantity=x;
	}
	
	/**
	 * Metodo que que obtiene el valor de una propiedad determinada (get, accesor) segun el valor de la propiedad
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de obtener una propiedad
	 * @return valor del atributo asociado a este accesor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public boolean getNumbered()
	{
		return this.numbered;
	}
	
	/**
	 * Metodo que que establece el valor de una propiedad determinada (set, mutador) segun un valor pasado por parametro
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de establecer una propiedad
	 * @param x nuevo valor del atributo
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setNumbered(boolean x)
	{
		this.numbered=x;
	}
}