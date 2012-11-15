package model;

import java.io.Serializable;

/**
 * Representa la asociacion que tienen un rol y un usuario en el sistema, es util para la entrada y salida de usuarios (logs)
 * @see User
 * @see RoleByUser
 * @author Luis Roldan Chacon
 * @author Gilberth Arce Hernandez
 */
public class RoleByUser implements Serializable
{
	private String username;
	private int roleCode;
	
	/**
	 * Constructor sin parametros que ayuda a la creacion de objetos vacios
	 * Estos son funcionales cuando no se cuenta con toda la informacion para la creacion del objeto
	 * o se quiere llenar la informacion poco a poco
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public RoleByUser()
	{
	}
	
	/**
	 * Constructor con parametros que ayuda a la creacion de objetos llenos
	 * Estos son funcionales cuando se cuenta con toda la informacion para la creacion del objeto
	 * y/o no se quiere guardar una referencia hacia un objeto
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public RoleByUser(String username, int roleCode)
	{
		this.username = username;
		this.roleCode = roleCode;
	}
	
	/**
	 * Constructor de copia que hace que un objeto tenga los mismos valores de otro
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public RoleByUser(RoleByUser roleByUser)
	{
		this.username = roleByUser.getUsername();
		this.roleCode = roleByUser.getRoleCode();
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
	
	/**
	 * Metodo que que establece el valor de una propiedad determinada (set, mutador) segun un valor pasado por parametro
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de establecer una propiedad
	 * @param username nuevo valor del atributo
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	/**
	 * Metodo que que obtiene el valor de una propiedad determinada (get, accesor) segun el valor de la propiedad
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de obtener una propiedad
	 * @return valor del atributo asociado a este accesor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public int getRoleCode()
	{
		return this.roleCode;
	}
	
	/**
	 * Metodo que que establece el valor de una propiedad determinada (set, mutador) segun un valor pasado por parametro
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de establecer una propiedad
	 * @param roleCode nuevo valor del atributo
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setRoleCode(int roleCode)
	{
		this.roleCode = roleCode;
	}
}