package model;

/**
 * Representa un rol en el sistema, estos son utiles para identificar los conjuntos de tareas que puede tener un usuario
 * y de esa manera acceder al sistema
 * @see User
 * @see RoleByUser
 * @author Luis Roldan Chacon
 * @author Gilberth Arce Hernandez
 */
public class Role
{
	private int code;
	private String description;
	
	/**
	 * Constructor sin parametros que ayuda a la creacion de objetos vacios
	 * Estos son funcionales cuando no se cuenta con toda la informacion para la creacion del objeto
	 * o se quiere llenar la informacion poco a poco
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public Role()
	{
	}
	
	/**
	 * Constructor con parametros que ayuda a la creacion de objetos llenos
	 * Estos son funcionales cuando se cuenta con toda la informacion para la creacion del objeto
	 * y/o no se quiere guardar una referencia hacia un objeto
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public Role(int code, String description)
	{
		this.code=code;
		this.description=description;
	}
	
	/**
	 * Constructor de copia que hace que un objeto tenga los mismos valores de otro
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public Role(Role roleDTO)
	{
		this.code=roleDTO.getCode();
		this.description=roleDTO.getDescription();
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
	public String getDescription()
	{
		return this.description;
	}
	
	/**
	 * Metodo que que establece el valor de una propiedad determinada (set, mutador) segun un valor pasado por parametro
	 * Ayuda a la encapsulacion de los datos y si se tiene codigo que se ejecuta despues de establecer una propiedad
	 * @param x nuevo valor del atributo
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setDescription(String x)
	{
		this.description=x;
	}
}