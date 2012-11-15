package controller;

import data.*;
import model.*;
import java.util.*;
import java.io.IOException;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.servlet.http.HttpSession;

/**
 * Controlador de la pantalla de ticket's, todas las acciones que tengan que ver con la compra de ticket's son manejadas por esta
 * clase
 * @see PromoterDAO
 * @see UserDAO
 * @see RoleByUserDAO
 * @author Luis Roldan Chacon
 * @author Gilberth Arce Hernandez
 */
public class PromoterController implements Controller
{
	private PromoterDAO promoterDAO;
	private UserDAO userDAO;
	private RoleByUserDAO roleByUserDAO;
	
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
		Map<String, Object> myModel = new HashMap<String, Object>();
		HttpSession session = request.getSession(false);
		if ((Boolean)session.getAttribute("Administrator"))
		{
			switch (request.getParameter("mode"))
			{
				case "new": return NewPromoter();
				case "insert": return Insert(request);
				case "detail": return Detail(request);
			    case "update": return Update(request);
				case "delete": return Delete(request);
				default: return List();
			}
		}
		else
		{
			myModel.put("error", "Acceso denegado");
			return new ModelAndView("login", "model", myModel);
		}
	}
	
	/**
	 * Maneja la peticion de crear el formulario para registrar un nuevo promotor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public ModelAndView NewPromoter() throws ServletException, IOException
	{
		return new ModelAndView("newPromoter", "model", null);
	}
	
	/**
	 * Maneja la peticion de listar todos los promotores
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public ModelAndView List() throws ServletException, IOException
	{
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("promoters", promoterDAO.find());
		return new ModelAndView("promotersList", "model", myModel);
	}
	
	/**
	 * Maneja la peticion de registrar un nuevo promotor
	 * @param request Objeto que representa la peticion al servidor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public ModelAndView Insert(HttpServletRequest request) throws ServletException, IOException
	{
		String username = request.getParameter("username");
		userDAO.save(new UserFactory().create(username, request.getParameter("pass")));
		roleByUserDAO.save(new RoleByUserFactory().create(username, 2));
		promoterDAO.save(new PromoterFactory().create(new Random().nextInt(), request.getParameter("name"), request.getParameter("address"), request.getParameter("telephone"), request.getParameter("account"), request.getParameter("bank"), Integer.parseInt(request.getParameter("comission")), username));
		return List();
	}
	
	/**
	 * Maneja la peticion de eliminar un promotor y su usuario
	 * @param request Objeto que representa la peticion al servidor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public ModelAndView Delete(HttpServletRequest request) throws ServletException, IOException
	{
		userDAO.delete(new UserFactory().create(request.getParameter("user"), null));
		promoterDAO.delete(new PromoterFactory().create(Integer.parseInt(request.getParameter("promoter")), null, null, null, null, null, 0, null));
		return List();
	}
	
	/**
	 * Maneja la peticion de mostrar el detalle de un promotor
	 * @param request Objeto que representa la peticion al servidor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public ModelAndView Detail(HttpServletRequest request) throws ServletException, IOException
	{
		Promoter promoter = promoterDAO.findByCode(Integer.parseInt(request.getParameter("promoter")));
		User user = userDAO.findByUsername(request.getParameter("user"));
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("promoter", promoter);
		myModel.put("user", user);
		return new ModelAndView("promotersDetail", "model", myModel);
	}

	/**
	 * Maneja la peticion de actualizar los datos de un promotor
	 * @param request Objeto que representa la peticion al servidor
	 * @author Luis Roldan Chacon
	 * @author Gilberth Arce Hernandez
	 */
	public ModelAndView Update(HttpServletRequest request) throws ServletException, IOException
	{
		userDAO.save(new UserFactory().create(request.getParameter("txtUserUserName"), request.getParameter("txtUserPass")));
		promoterDAO.save(new PromoterFactory().create(Integer.parseInt(request.getParameter("txtPromoterCode")), request.getParameter("txtPromoterName"), request.getParameter("txtPromoterAddress"), request.getParameter("txtPromoterTelephone"), request.getParameter("txtPromoterAccount"), request.getParameter("txtPromoterBank"), Integer.parseInt(request.getParameter("txtPromoterComission")), request.getParameter("txtUserUserName")));
		return List();
	}
}