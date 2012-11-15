package model;

/**
 * Representa un Cliente para el sistema, una de las partes importantes del facturado y control de ventas
 * Cada tiquete vendido tiene una referencia al cliente al que se le vendio, el promotor puede ver las facturas
 * de cada tiquete vendido por evento y tipo de localidad
 * @see Ticket
 * @see Promoter
 * @author Luis Roldan Chacon
 * @author Gilberth Arce Hernandez
 */
public class Customer
{
	private String id;
	private String name;
	private String address;
	private String telephone;
	private String cardNumber;
	private String cardType;
	
	/**
	 * Constructor sin parametros que ayuda a la creacion de objetos vacios
	 * Estos son funcionales cuando no se cuenta con toda la informacion para la creacion del objeto
	 * o se quiere llenar la informacion poco a poco
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public Customer()
	{
	}
	
	/**
	 * Constructor con parametros que ayuda a la creacion de objetos llenos
	 * Estos son funcionales cuando se cuenta con toda la informacion para la creacion del objeto
	 * y/o no se quiere guardar una referencia hacia un objeto
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public Customer(String id, String name, String address, String telephone, String cardNumber, String cardType)
	{
		this.id=id;
		this.name=name;
		this.address=address;
		this.telephone=telephone;
		this.cardNumber=cardNumber;
		this.cardType=cardType;
	}
	
	/**
	 * Constructor de copia que hace que un objeto tenga los mismos valores de otro
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public Customer(Customer customerDTO)
	{
		this.id=customerDTO.getId();
		this.address=customerDTO.getAddress();
		this.telephone=customerDTO.getTelephone();
		this.cardNumber=customerDTO.getCardNumber();
		this.cardType=customerDTO.getCardType();
	}
	
	/**
	 * Metodo que que obtiene el valor de una propiedad determinada (get, accesor) segun el valor de la propiedad
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de obtener una propiedad
	 * @return valor del atributo asociado a este accesor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public String getId()
	{
		return this.id;
	}
	
	/**
	 * Metodo que que establece el valor de una propiedad determinada (set, mutador) segun un valor pasado por parametro
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de establecer una propiedad
	 * @param x nuevo valor del atributo
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setId(String x)
	{
		this.id=x;
	}
	
	/**
	 * Metodo que que obtiene el valor de una propiedad determinada (get, accesor) segun el valor de la propiedad
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de obtener una propiedad
	 * @return valor del atributo asociado a este accesor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Metodo que que establece el valor de una propiedad determinada (set, mutador) segun un valor pasado por parametro
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de establecer una propiedad
	 * @param x nuevo valor del atributo
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setName(String name)
	{
		this.name=name;
	}
	
	/**
	 * Metodo que que obtiene el valor de una propiedad determinada (get, accesor) segun el valor de la propiedad
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de obtener una propiedad
	 * @return valor del atributo asociado a este accesor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public String getAddress()
	{
		return this.address;
	}
	
	/**
	 * Metodo que que establece el valor de una propiedad determinada (set, mutador) segun un valor pasado por parametro
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de establecer una propiedad
	 * @param x nuevo valor del atributo
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setAddress(String x)
	{
		this.address=x;
	}
	
	/**
	 * Metodo que que obtiene el valor de una propiedad determinada (get, accesor) segun el valor de la propiedad
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de obtener una propiedad
	 * @return valor del atributo asociado a este accesor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public String getTelephone()
	{
		return this.telephone;
	}
	
	/**
	 * Metodo que que establece el valor de una propiedad determinada (set, mutador) segun un valor pasado por parametro
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de establecer una propiedad
	 * @param x nuevo valor del atributo
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setTelephone(String x)
	{
		this.telephone=x;
	}
	
	/**
	 * Metodo que que obtiene el valor de una propiedad determinada (get, accesor) segun el valor de la propiedad
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de obtener una propiedad
	 * @return valor del atributo asociado a este accesor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public String getCardNumber()
	{
		return this.cardNumber;
	}
	
	/**
	 * Metodo que que establece el valor de una propiedad determinada (set, mutador) segun un valor pasado por parametro
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de establecer una propiedad
	 * @param x nuevo valor del atributo
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setCardNumber(String x)
	{
		this.cardNumber=x;
	}
	
	/**
	 * Metodo que que obtiene el valor de una propiedad determinada (get, accesor) segun el valor de la propiedad
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de obtener una propiedad
	 * @return valor del atributo asociado a este accesor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public String getCardType()
	{
		return this.cardType;
	}
	
	/**
	 * Metodo que que establece el valor de una propiedad determinada (set, mutador) segun un valor pasado por parametro
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de establecer una propiedad
	 * @param x nuevo valor del atributo
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setCardType(String x)
	{
		this.cardType=x;
	}
}