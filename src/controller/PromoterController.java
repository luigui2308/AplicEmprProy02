package controller;

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
import model.*;

/**
 * Controla los eventos propios para Promotores
 * @author Luis Roldan Chacon
 * @author Gilberth Arce Hernandez
 */

public class PromoterController implements Controller
{
	private PromoterDAO promoterDAO;
	private UserDAO userDAO;
	private RoleByUserDAO roleByUserDAO;
	
	public void setPromoterDAO(PromoterDAO promoterDAO)
	{
		this.promoterDAO = promoterDAO;
	}
	public PromoterDAO getPromoterDAO()
	{
		return this.promoterDAO;
	}
	
	public void setUserDAO(UserDAO userDAO)
	{
		this.userDAO = userDAO;
	}
	public UserDAO getUserDAO()
	{
		return this.userDAO;
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
	
	public ModelAndView NewPromoter() throws ServletException, IOException
	{
		return new ModelAndView("newPromoter", "model", null);
	}
	
	public ModelAndView List() throws ServletException, IOException
	{
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("promoters", promoterDAO.find());
		return new ModelAndView("promotersList", "model", myModel);
	}
	
	public ModelAndView Insert(HttpServletRequest request) throws ServletException, IOException
	{
		Promoter promoter = new Promoter();
		Random generator = new Random();
		promoter.setCode(generator.nextInt());
		promoter.setName(request.getParameter("name"));
		promoter.setAddress(request.getParameter("address"));
		promoter.setTelephone(request.getParameter("telephone"));
		promoter.setAccount(request.getParameter("account"));
		promoter.setBank(request.getParameter("bank"));
		promoter.setComission(Integer.parseInt(request.getParameter("comission")));
		promoter.setUsername(request.getParameter("username"));
		InsertUser(request);
		promoterDAO.save(promoter);
		return List();
	}
	
	public void InsertUser(HttpServletRequest request) throws ServletException, IOException
	{
		User user = new User();
		String username = request.getParameter("username");
		user.setUsername(username);
		user.setPassword(request.getParameter("pass"));
		userDAO.save(user);
		RoleByUser role = new RoleByUser();
		role.setUsername(username);
		role.setRoleCode(2);
		roleByUserDAO.save(role);
	}
	
	public ModelAndView Delete(HttpServletRequest request) throws ServletException, IOException
	{
		Promoter promoter = new Promoter();
		promoter.setCode(Integer.parseInt(request.getParameter("promoter")));
		DeleteUser(request.getParameter("user"));
		promoterDAO.delete(promoter);
		return List();
	}
	
	public void DeleteUser(String username) throws ServletException, IOException
	{
		User user = new User();
		user.setUsername(username);
		userDAO.delete(user);
	}
	
	public ModelAndView Detail(HttpServletRequest request) throws ServletException, IOException
	{
		Promoter promoter = promoterDAO.findByCode(Integer.parseInt(request.getParameter("promoter")));
		User user = userDAO.findByUsername(request.getParameter("user"));
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("promoter", promoter);
		myModel.put("user", user);
		return new ModelAndView("promotersDetail", "model", myModel);
	}

	public ModelAndView Update(HttpServletRequest request) throws ServletException, IOException
	{
		User user = new User();
		user.setUsername(request.getParameter("txtUserUserName"));
		user.setPassword(request.getParameter("txtUserPass"));
		userDAO.save(user);
		Promoter promoter = new Promoter();
		promoter.setCode(Integer.parseInt(request.getParameter("txtPromoterCode")));
		promoter.setName(request.getParameter("txtPromoterName"));
		promoter.setAddress(request.getParameter("txtPromoterAddress"));
		promoter.setTelephone(request.getParameter("txtPromoterTelephone"));
		promoter.setAccount(request.getParameter("txtPromoterAccount"));
		promoter.setBank(request.getParameter("txtPromoterBank"));
		promoter.setComission(Integer.parseInt(request.getParameter("txtPromoterComission")));
		promoter.setUsername(request.getParameter("txtUserUserName"));
		promoterDAO.save(promoter);
		return List();
	}
}