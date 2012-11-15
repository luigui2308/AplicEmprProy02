package controller;

import data.*;
import model.*;
import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Controlador de la pantalla de ticket's, todas las acciones que tengan que ver con la compra de ticket's son manejadas por esta
 * clase
 * @see UserDAO
 * @see PromoterDAO
 * @see RoleByUserDAO
 * @author Luis Roldan Chacon
 * @author Gilberth Arce Hernandez
 */
public class UserController implements Controller
{
	private UserDAO userDAO;
	private PromoterDAO promoterDAO;
	private RoleByUserDAO roleByUserDAO;
	
	/**
	 * Establece un nuevo valor para el DAO, el metodo es requerido por el inicializador context
	 * @param userDAO nuevo valor para el DAO
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setUserDAO(UserDAO userDAO)
	{
		this.userDAO = userDAO;
	}
	
	/**
	 * Obtiene el valor de un DAO, este metodo es requerido por el inicializador context
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public UserDAO getUserDAO()
	{
		return this.userDAO;
	}
	
	/**
	 * Establece un nuevo valor para el DAO, el metodo es requerido por el inicializador context
	 * @param promoterDAO nuevo valor para el DAO
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setPromoterDAO(PromoterDAO promoterDAO)
	{
		this.promoterDAO = promoterDAO;
	}
	
	/**
	 * Obtiene el valor de un DAO, este metodo es requerido por el inicializador context
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public PromoterDAO getPromoterDAO()
	{
		return this.promoterDAO;
	}
	
	/**
	 * Establece un nuevo valor para el DAO, el metodo es requerido por el inicializador context
	 * @param roleByUserDAO nuevo valor para el DAO
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public void setRoleByUserDAO(RoleByUserDAO roleByUserDAO)
	{
		this.roleByUserDAO = roleByUserDAO;
	}
	
	/**
	 * Obtiene el valor de un DAO, este metodo es requerido por el inicializador context
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public RoleByUserDAO getRoleByUserDAO()
	{
		return this.roleByUserDAO;
	}

	/**
	 * Metodo que sirve de enrutador para todas las peticiones relacionadas con ticket's, es necesario que el request tenga 
	 * el parametro mode valido
	 * @param request Objeto que representa la peticion al servidor
	 * @param response Objeto que representa la respuesta del servidor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		switch (request.getParameter("mode"))
		{
			case "new": return newForm(request, response);
			case "login": return login(request, response);
			case "logout": return logout(request, response);
			default: return mainMenu(request, response);//main
		}
	}

	/**
	 * Maneja la peticion de crear el formulario para ingresar un usuario al sistema (logearlo)
	 * @param request Objeto que representa la peticion al servidor
	 * @param response Objeto que representa la respuesta del servidor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public ModelAndView newForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		return new ModelAndView("Login", "model", null);
	}

	/**
	 * Maneja la peticion de logear un usuario en el sistema
	 * @param request Objeto que representa la peticion al servidor
	 * @param response Objeto que representa la respuesta del servidor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession(true);
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		User user = userDAO.findByUsername(username);
		if (user != null && user.getPassword().equals(pass))
		{
			session.setAttribute("Username", username);
			session.setAttribute("Administrator", false);
			session.setAttribute("Promoter", false);
			for (Object roleByUser : roleByUserDAO.findByUsername(username))
			{
				switch (((RoleByUser)roleByUser).getRoleCode())
				{
					case 1: session.setAttribute("Administrator", true); break;
					case 2:
						session.setAttribute("Promoter", true);
						session.setAttribute("PromoterCode", promoterDAO.findByUsername(username).getCode());
					break;
				}				
			}
		}
		else
		{
			Map<String, Object> myModel = new HashMap<String, Object>();
			myModel.put("error", new Exception("Usuario o clave incorrectos"));
			myModel.put("username", username);
			return new ModelAndView("Login", "model", myModel);
		}
		return mainMenu(request, response);
	}

	/**
	 * Maneja la peticion de deslogear un usuario del sistema
	 * @param request Objeto que representa la peticion al servidor
	 * @param response Objeto que representa la respuesta del servidor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.getSession(false).invalidate();
		return mainMenu(request, response);
	}

	/**
	 * Maneja la peticion de mostrar el menu principal de la aplicacion
	 * @param request Objeto que representa la peticion al servidor
	 * @param response Objeto que representa la respuesta del servidor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public ModelAndView mainMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		return new ModelAndView("paginaPrincipal", "model", null);
	}
}