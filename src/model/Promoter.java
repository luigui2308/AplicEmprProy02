package model;

/**
 * Representa un Promotor para el sistema, estos estan encargados de poner los eventos y asignarles las
 * localidades, las cuales seran compradas por los clientes en forma de tickets
 * @see Ticket
 * @see Location
 * @see Event
 * @author Luis Roldan Chacon
 * @author Gilberth Arce Hernandez
 */
public class Promoter
{
	private int code;
	private String name;
	private String address;
	private String telephone;
	private String account;
	private String bank;
	private int comission;
	private String username;
	
	/**
	 * Constructor sin parametros que ayuda a la creacion de objetos vacios
	 * Estos son funcionales cuando no se cuenta con toda la informacion para la creacion del objeto
	 * o se quiere llenar la informacion poco a poco
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public Promoter()
	{
	}
	
	/**
	 * Constructor con parametros que ayuda a la creacion de objetos llenos
	 * Estos son funcionales cuando se cuenta con toda la informacion para la creacion del objeto
	 * y/o no se quiere guardar una referencia hacia un objeto
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public Promoter(int code, String name, String address, String telephone, String account, String bank, int comission, String username)
	{
		this.code=code;
		this.name=name;
		this.address=address;
		this.telephone=telephone;
		this.account=account;
		this.bank=bank;
		this.comission=comission;
		this.username=username;
	}
	
	/**
	 * Constructor de copia que hace que un objeto tenga los mismos valores de otro
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public Promoter(Promoter promoterDTO)
	{
		this.code=promoterDTO.getCode();
		this.name=promoterDTO.getName();
		this.address=promoterDTO.getAddress();
		this.telephone=promoterDTO.getTelephone();
		this.account=promoterDTO.getAccount();
		this.bank=promoterDTO.getBank();
		this.comission=promoterDTO.getComission();
		this.username=promoterDTO.getUsername();
	}
	
	/**
	 * Metodo que que establece el valor de una propiedad determinada (set, mutador) segun un valor pasado por parametro
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de establecer una propiedad
	 * @param x nuevo valor del atributo
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setCode(int x)
	{
		this.code=x;
	}
	
	/**
	 * Metodo que que obtiene el valor de una propiedad determinada (get, accesor) segun el valor de la propiedad
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de obtener una propiedad
	 * @return valor del atributo asociado a este accesor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public int getCode()
	{
		return this.code;
	}
	
	/**
	 * Metodo que que establece el valor de una propiedad determinada (set, mutador) segun un valor pasado por parametro
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de establecer una propiedad
	 * @param x nuevo valor del atributo
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setName(String x)
	{
		this.name=x;
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
	public void setAccount(String x)
	{
		this.account=x;
	}
	
	/**
	 * Metodo que que obtiene el valor de una propiedad determinada (get, accesor) segun el valor de la propiedad
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de obtener una propiedad
	 * @return valor del atributo asociado a este accesor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public String getAccount()
	{
		return this.account;
	}
	
	/**
	 * Metodo que que establece el valor de una propiedad determinada (set, mutador) segun un valor pasado por parametro
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de establecer una propiedad
	 * @param x nuevo valor del atributo
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setBank(String x)
	{
		this.bank=x;
	}
	
	/**
	 * Metodo que que obtiene el valor de una propiedad determinada (get, accesor) segun el valor de la propiedad
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de obtener una propiedad
	 * @return valor del atributo asociado a este accesor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public String getBank()
	{
		return this.bank;
	}
	
	/**
	 * Metodo que que establece el valor de una propiedad determinada (set, mutador) segun un valor pasado por parametro
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de establecer una propiedad
	 * @param x nuevo valor del atributo
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setComission(int x)
	{
		this.comission=x;
	}
	
	/**
	 * Metodo que que obtiene el valor de una propiedad determinada (get, accesor) segun el valor de la propiedad
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de obtener una propiedad
	 * @return valor del atributo asociado a este accesor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public int getComission()
	{
		return this.comission;
	}
	
	/**
	 * Metodo que que establece el valor de una propiedad determinada (set, mutador) segun un valor pasado por parametro
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de establecer una propiedad
	 * @param x nuevo valor del atributo
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setUsername(String x)
	{
		this.username=x;
	}
	
	/**
	 * Metodo que que obtiene el valor de una propiedad determinada (get, accesor) segun el valor de la propiedad
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de obtener una propiedad
	 * @return valor del atributo asociado a este accesor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public String getUsername()
	{
		return this.username;
	}
}