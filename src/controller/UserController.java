package controller;

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
import model.*;

public class UserController implements Controller
{
	private UserDAO userDAO;
	private PromoterDAO promoterDAO;
	private RoleByUserDAO roleByUserDAO;
	
	public void setUserDAO(UserDAO userDAO)
	{
		this.userDAO = userDAO;
	}
	public UserDAO getUserDAO()
	{
		return this.userDAO;
	}
	
	public void setPromoterDAO(PromoterDAO promoterDAO)
	{
		this.promoterDAO = promoterDAO;
	}
	public PromoterDAO getPromoterDAO()
	{
		return this.promoterDAO;
	}
	
	public void setRoleByUserDAO(RoleByUserDAO roleByUserDAO)
	{
		this.roleByUserDAO = roleByUserDAO;
	}
	public RoleByUserDAO getRoleByUserDAO()
	{
		return this.roleByUserDAO;
	}

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

	public ModelAndView newForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		return new ModelAndView("Login", "model", null);
	}

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

	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.getSession(false).invalidate();
		return mainMenu(request, response);
	}

	public ModelAndView mainMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		return new ModelAndView("paginaPrincipal", "model", null);
	}
}